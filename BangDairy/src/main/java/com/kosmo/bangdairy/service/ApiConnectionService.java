package com.kosmo.bangdairy.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.StillVO;

@Service("apiConnectionService")
public class ApiConnectionService {
	@Autowired
	ThreadInsertService threadInsertService;
	static final Logger logger =  (Logger)LogManager.getLogger("Service");
	private ArrayList<MovieVO> getMovie(Calendar cal) throws Exception {
		//http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&createDts=2019&director=%EB%B4%89%EC%A4%80%ED%98%B8&listCount=3&detail=Y&ServiceKey=5U295LSU679NZDLWTCK5
		 /*URL*/ 
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dts = df.format(cal.getTime());
		cal.add(Calendar.MONTH, 1);
		String dtsPlus = df.format(cal.getTime());
		  StringBuilder urlBuilder = new StringBuilder("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y");//
		 
		  /*Service Key*/ 
		  urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") +"=5U295LSU679NZDLWTCK5");
		 //releaseDts 개봉일 시작
		  urlBuilder.append("&" + URLEncoder.encode("releaseDts","UTF-8") +"="+dts);
		//releaseDte 개봉일종료
		  urlBuilder.append("&" + URLEncoder.encode("releaseDte","UTF-8") +"="+dtsPlus);
		  System.out.println(df.format(cal.getTime()));
		  urlBuilder.append("&" + URLEncoder.encode("listCount","UTF-8") +"="+500);
		  URL url = new URL(urlBuilder.toString());
		  System.out.println(urlBuilder.toString());
		  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		  conn.setRequestMethod("GET"); conn.setRequestProperty("Content-type", "application/json");
		  System.out.println("Response code: " + conn.getResponseCode());
		  BufferedReader rd; 
		  if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			  rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		  } else {
			  rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
			  
		  } 
		  StringBuilder sb = new StringBuilder(); 
		  String line; 
		  while ((line = rd.readLine()) != null) 
		  { 
			  sb.append(line); 
		  }
		  rd.close();
		  conn.disconnect();
		  //Json parsing
		  JsonParser jp = new JsonParser();
		  JsonObject json = jp.parse(sb.toString().replace("'", "")).getAsJsonObject();
		  Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		  System.out.println(gson.toJson(json));
		  JsonArray jarr = json.get("Data").getAsJsonArray();
		  ArrayList<MovieVO> voArr = new ArrayList<MovieVO>();
		  for (JsonElement jsonElement : jarr) {
			JsonArray arrResult = jsonElement.getAsJsonObject().get("Result").getAsJsonArray();
			System.out.println("--------------------------------");
			//결과받기
			for (JsonElement result : arrResult) {
				MovieVO vo = new MovieVO();
				JsonObject rs = result.getAsJsonObject();
				vo.setMovieId(rs.get("DOCID").getAsString());
				vo.setMovieTitle(rs.get("title").getAsString().trim()); //영화제목
				vo.setMovieEngTitle(rs.get("titleEng").getAsString()); //영어제목
				String openingDate = rs.get("ratings").getAsJsonObject().get("rating")
						.getAsJsonArray().get(0)
						.getAsJsonObject().get("releaseDate").getAsString(); //개봉일
				//개봉일 자르기
				if (openingDate.indexOf("|")!=-1) {
					vo.setOpeningDateStr(openingDate.split("[|]")[0]);
				}else vo.setOpeningDateStr(openingDate);
				JsonArray directors = rs.get("directors").getAsJsonObject().get("director").getAsJsonArray(); //감독배열
				ArrayList<DirectorVO> drs = new ArrayList<DirectorVO>(); //감독리스트
				for (JsonElement direct : directors) { // for문시작
					DirectorVO dvo = new DirectorVO();
					JsonObject director_each = direct.getAsJsonObject();
					dvo.setDirectorName(director_each.get("directorNm").getAsString());
					dvo.setDirectorEngName(director_each.get("directorEnNm").getAsString());
					dvo.setDirectorId(director_each.get("directorId").getAsString());
					drs.add(dvo);
				} //for문끝
				vo.setMovieDirector(drs);
				//장르정보 vo 등록
				StringTokenizer  st = new StringTokenizer(rs.get("genre").getAsString(),",");
				ArrayList<GenreVO> gvoArr = new ArrayList<GenreVO>();
				while(st.hasMoreTokens()) {
					GenreVO gvo = new GenreVO();
					gvo.setGenreTitle(st.nextToken());
					gvoArr.add(gvo);
				}
				vo.setMovieGenre(gvoArr);
				vo.setCountry(rs.get("nation").getAsString());
				vo.setCompany(rs.get("company").isJsonNull()?"":rs.get("company").getAsString());
				JsonObject plots = rs.get("plots").getAsJsonObject().get("plot").getAsJsonArray().get(0).getAsJsonObject();
				vo.setPlot(plots.get("plotText").getAsString());
				vo.setShowtimes(rs.get("runtime").getAsString());
				vo.setViewingClass(rs.get("rating").getAsString());
				vo.setKeyword(rs.get("keywords").getAsString());
				String pos = rs.get("posters").getAsString();
				if (pos.indexOf("|")!=-1) {
					vo.setPosterAddr(pos.split("[|]")[0]);
				}else vo.setPosterAddr(pos);
				//스틸컷 정보 vo등록
				StringTokenizer stStill = new StringTokenizer(rs.get("stlls").getAsString());
				ArrayList<StillVO> stillArr = new ArrayList<StillVO>();
				while (stStill.hasMoreTokens()) {
					StillVO svo = new StillVO();
					svo.setStillAddr(stStill.nextToken());
					stillArr.add(svo);
				}
				//배우정보 vo등록
				JsonArray staffs = rs.get("staffs").getAsJsonObject().get("staff").getAsJsonArray();
				HashMap<ActorVO, String> actMap = new HashMap<ActorVO, String>();
				for (JsonElement jStaff : staffs) {
					JsonObject joStaff = jStaff.getAsJsonObject();
					if (joStaff.get("staffRoleGroup").toString().replace("\"", "").equals("출연")) {
						if(joStaff.get("staffId")!=null) {
							ActorVO avo = new ActorVO();
							avo.setActorName(joStaff.get("staffNm").getAsString());
							avo.setActorEngName(joStaff.get("staffEnNm").getAsString());
							avo.setActorId(joStaff.get("staffId").getAsString());
							actMap.put(avo, joStaff.get("staffRole").getAsString());
						}
					}
				}
				vo.setStarring(actMap);
				vo.setPreviewAddr(rs.get("vods").getAsJsonObject().get("vod").getAsJsonArray().get(0).getAsJsonObject().get("vodUrl").getAsString());
//				System.out.println(vo);
				voArr.add(vo);
			}
		}
		return voArr;
	}
	private ArrayList<MovieVO> updateMovieOpening(Calendar cal) throws Exception {
		//http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&createDts=2019&director=%EB%B4%89%EC%A4%80%ED%98%B8&listCount=3&detail=Y&ServiceKey=5U295LSU679NZDLWTCK5
		 /*URL*/ 
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dts = df.format(cal.getTime());
		cal.add(Calendar.MONTH, 1);
		String dtsPlus = df.format(cal.getTime());
		  StringBuilder urlBuilder = new StringBuilder("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y");//
		 
		  /*Service Key*/ 
		  urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") +"=5U295LSU679NZDLWTCK5");
		 //releaseDts 개봉일 시작
		  urlBuilder.append("&" + URLEncoder.encode("releaseDts","UTF-8") +"="+dts);
		//releaseDte 개봉일종료
		  urlBuilder.append("&" + URLEncoder.encode("releaseDte","UTF-8") +"="+dtsPlus);
		  System.out.println(df.format(cal.getTime()));
		  urlBuilder.append("&" + URLEncoder.encode("listCount","UTF-8") +"="+500);
		  URL url = new URL(urlBuilder.toString());
		  System.out.println(urlBuilder.toString());
		  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		  conn.setRequestMethod("GET"); conn.setRequestProperty("Content-type", "application/json");
		  System.out.println("Response code: " + conn.getResponseCode());
		  BufferedReader rd; 
		  if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			  rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		  } else {
			  rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
			  
		  } 
		  StringBuilder sb = new StringBuilder(); 
		  String line; 
		  while ((line = rd.readLine()) != null) 
		  { 
			  sb.append(line); 
		  }
		  rd.close();
		  conn.disconnect();
		  //Json parsing
		  JsonParser jp = new JsonParser();
		  JsonObject json = jp.parse(sb.toString().replace("'", "")).getAsJsonObject();
		  Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		  System.out.println(gson.toJson(json));
		  JsonArray jarr = json.get("Data").getAsJsonArray();
		  ArrayList<MovieVO> voArr = new ArrayList<MovieVO>();
		  for (JsonElement jsonElement : jarr) {
			JsonArray arrResult = jsonElement.getAsJsonObject().get("Result").getAsJsonArray();
			System.out.println("--------------------------------");
			//결과받기
			for (JsonElement result : arrResult) {
				MovieVO vo = new MovieVO();
				JsonObject rs = result.getAsJsonObject();
				vo.setMovieId(rs.get("DOCID").getAsString());
				vo.setOpeningDateStr(rs.get("ratings").getAsJsonObject().get("rating")
						.getAsJsonArray().get(0)
						.getAsJsonObject().get("releaseDate").getAsString()); //개봉일
				voArr.add(vo);
			}
		}
		return voArr;
	}
	private void insertMovie(ArrayList<MovieVO> arr){
		if (arr!=null) {
			threadInsertService.insertMovie(arr);
		}
	}
	public void runService(Calendar cal) {
		ArrayList<MovieVO> movieArr = null;
		try {
			movieArr = getMovie(cal);
//			movieArr = updateMovieOpening(cal);
		} catch (Exception e) {
			logger.error("api접근 오류 : "+e.getMessage());
		}
		insertMovie(movieArr);
	}

}
