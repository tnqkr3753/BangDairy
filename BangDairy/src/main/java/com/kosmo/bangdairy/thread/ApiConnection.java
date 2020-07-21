package com.kosmo.bangdairy.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

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

public class ApiConnection implements Runnable {
	String aDate;
	public ApiConnection(String aDate) {
		this.aDate = aDate;
	}
	public static void getMovie(Calendar cal) throws Exception {
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
//		  urlBuilder.append("&" + URLEncoder.encode("val001","UTF-8") + "=" + URLEncoder.encode("2000", "UTF-8"));
		  URL url = new URL(urlBuilder.toString());
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
		  JsonParser jp = new JsonParser();
		  JsonObject json = jp.parse(sb.toString()).getAsJsonObject();
		  Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		  System.out.println(gson.toJson(json));
		  JsonArray jarr = json.get("Data").getAsJsonArray();
		  ArrayList<MovieVO> voArr = new ArrayList<MovieVO>();
		  for (JsonElement jsonElement : jarr) {
			JsonArray arrResult = jsonElement.getAsJsonObject().get("Result").getAsJsonArray();
			System.out.println("--------------------------------");
			
			for (JsonElement result : arrResult) {
				MovieVO vo = new MovieVO();
				JsonObject rs = result.getAsJsonObject();
				vo.setMovieTitle(rs.get("title").getAsString());
				vo.setMovieEngTitle(rs.get("titleEng").getAsString());
				vo.setOpeningDateStr(rs.get("repRatDate").getAsString());
				JsonArray directors = rs.get("directors").getAsJsonObject().get("director").getAsJsonArray();
				ArrayList<DirectorVO> drs = new ArrayList<DirectorVO>();
				for (JsonElement direct : directors) {
					DirectorVO dvo = new DirectorVO();
					JsonObject director_each = direct.getAsJsonObject();
					dvo.setDirectorName(director_each.get("directorNm").getAsString());
					dvo.setDirectorEngName(director_each.get("directorEnNm").getAsString());
					dvo.setDirectorId(director_each.get("directorId").getAsString());
					drs.add(dvo);
				}
				vo.setMovieDirector(drs);
				StringTokenizer  st = new StringTokenizer(rs.get("genre").getAsString(),",");
				ArrayList<GenreVO> gvoArr = new ArrayList<GenreVO>();
				while(st.hasMoreTokens()) {
					GenreVO gvo = new GenreVO();
					gvo.setGenreTitle(st.nextToken());
					gvoArr.add(gvo);
				}
				vo.setMovieGenre(gvoArr);
//				JsonArray actors = rs.get("actors").getAsJsonObject().get("actor").getAsJsonArray();
//				for (JsonElement jActors : actors) {
//					actMap.put(avo, null);
//				}
				vo.setContry(rs.get("nation").getAsString());
				vo.setCompany(rs.get("company").isJsonNull()?"":rs.get("company").getAsString());
				JsonObject plots = rs.get("plots").getAsJsonObject().get("plot").getAsJsonArray().get(0).getAsJsonObject();
				vo.setPlot(plots.get("plotText").getAsString());
				vo.setShowtimes(rs.get("runtime").getAsString());
				vo.setViewingClass(rs.get("rating").getAsString());
				vo.setKeyword(rs.get("keywords").getAsString());
				vo.setPosterAddr(rs.get("posters").getAsString());
//				System.out.println("releaseDate : "+rs.get("releaseDate"));
				StringTokenizer stStill = new StringTokenizer(rs.get("stlls").getAsString());
				ArrayList<StillVO> stillArr = new ArrayList<StillVO>();
				while (stStill.hasMoreTokens()) {
					StillVO svo = new StillVO();
					svo.setStillAddr(stStill.nextToken());
					stillArr.add(svo);
				}
				JsonArray staffs = rs.get("staffs").getAsJsonObject().get("staff").getAsJsonArray();
				HashMap<ActorVO, String> actMap = new HashMap<ActorVO, String>();
				for (JsonElement jStaff : staffs) {
					JsonObject joStaff = jStaff.getAsJsonObject();
					if (joStaff.get("staffRoleGroup").toString().replace("\"", "").equals("출연")) {
						ActorVO avo = new ActorVO();
						avo.setActorName(joStaff.get("staffNm").getAsString());
						avo.setActorEngName(joStaff.get("staffEnNm").getAsString());
						actMap.put(avo, joStaff.get("staffRole").getAsString());
					}
				}
				vo.setStarring(actMap);
				vo.setPreviewAddr(rs.get("vods").getAsJsonObject().get("vod").getAsJsonArray().get(0).getAsJsonObject().get("vodUrl").getAsString());
				System.out.println("************************");
				System.out.println(vo);
				System.out.println("////////////////////////////");
			}
		}
	}
	@Override
	public void run() {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = df.parse(aDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		try {
			getMovie(cal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
