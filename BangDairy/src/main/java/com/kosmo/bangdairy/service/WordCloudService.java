package com.kosmo.bangdairy.service;

import java.util.List;
import java.util.Map;

import com.kosmo.bangdairy.vo.MovieVO;

public interface WordCloudService {
	public List<Map<String, Object>> getWordCloud(MovieVO vo,String type);
}
