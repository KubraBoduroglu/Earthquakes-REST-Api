package com.kubraboduroglu.projects.earthquakes.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EarthquakesServiceImpl implements EarthquakesService{

	RestTemplate restTemplate = new RestTemplate();
	private static final String USGS_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";
	
	Map<String, String> paramMap = new HashMap<>();
	
	public String getCountv1(String startTime, String endTime) {
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		
		String countUrl = "https://earthquake.usgs.gov/fdsnws/event/1/count?starttime={starttime}&endtime={endtime}";
		
		String count = restTemplate.getForObject(countUrl, String.class, paramMap);
		return count;
	}
	
	public ResponseEntity<String> getCountv2(String startTime, String endTime) {
		
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		
		String countUrl = "https://earthquake.usgs.gov/fdsnws/event/1/count?starttime={starttime}&endtime={endtime}";
		
		ResponseEntity<String> count = restTemplate.getForEntity(countUrl, String.class, paramMap);
		return count;
	}
}
