package com.kosmo.bangdairy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.dao.WordCloudDAO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.ReviewVO;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

@Service("wordCloudService")
public class WordCloudServiceImpl implements WordCloudService {

	@Autowired
	WordCloudDAO wordCloudDAO;
	
	@Override
	public List<Map<String, Object>> getWordCloud(MovieVO vo) {
		Komoran komoran = new Komoran(DEFAULT_MODEL.LIGHT);
		Set<String> wordSet = new HashSet<String>();
		Map<String, Integer> wordCnt = new HashMap<String, Integer>();
		List<ReviewVO> list = wordCloudDAO.getReviewContent(vo);
		for (ReviewVO reviewVO : list) {
			if(reviewVO.getReviewContent()!=null ||! reviewVO.getReviewContent().equals("")) {
				KomoranResult analizeResultList = komoran.analyze(reviewVO.getReviewContent());
	//			List<String> posList = new ArrayList<String>();
	//			posList.add("NN"); //명사
	//			posList.add("IC"); //감탄사
	//			posList.add("VV"); //동사
	//			posList.add("VA"); //형용사
				try {
					List<Token> tList = analizeResultList.getTokenList();
					for (Token tk : tList) {
						String word = tk.getMorph();
						if(word.equals("으로")||word.equals("에서")||word.equals("이다")||
								word.equals("있다")||word.equals("일본")) {
							continue;
						}
						if(word.length()>1) {
							if(wordSet.contains(word)) {
								wordCnt.put(word, wordCnt.get(word)+1);
							}else if(wordSet.isEmpty()) {
								wordCnt.put(word, 1);
							}else {
								wordCnt.put(word, 1);
							}
							wordSet.add(word);
						}
					}
				}catch (Exception e) {
					LoggerAspect.logger.error("코모란 오류 : " + e.getMessage());
				}
			}
		}
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		for(String tmp : wordSet) {
			if(wordCnt.get(tmp)<10) continue;
			else {
				Map<String, Object> map = new LinkedHashMap<String, Object>();
				map.put("text", tmp);
				map.put("size", wordCnt.get(tmp));
				resultList.add(map);
			}
		}
		return resultList;
	}

}
