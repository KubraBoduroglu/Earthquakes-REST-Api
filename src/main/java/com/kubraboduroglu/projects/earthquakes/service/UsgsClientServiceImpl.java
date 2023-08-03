package com.kubraboduroglu.projects.earthquakes.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class UsgsClientServiceImpl implements UsgsClientService{

	RestTemplate restTemplate = new RestTemplate();
	private static final String USGS_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";
	private static final String countUrl = "https://earthquake.usgs.gov/fdsnws/event/1/count?starttime={starttime}&endtime={endtime}";
	private static final String USGS_QUERY_URL="https://earthquake.usgs.gov/fdsnws/event/1/query";
	
	Map<String, Object> paramMap = new HashMap<>();
	ResponseEntity<String> usgsData;
	
	//WebClient client = WebClient.create();
	WebClient webClient = WebClient.builder()
		    .baseUrl("http://localhost:8080")
		    .build();
	
	public String getCountObject(String startTime, String endTime) {
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
				
		String count = restTemplate.getForObject(countUrl, String.class, paramMap);
		return count;
	}
	
	public ResponseEntity<String> getCountEntity(String startTime, String endTime) {
		
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
				
		ResponseEntity<String> count = restTemplate.getForEntity(countUrl, String.class, paramMap);
		return count;
	}

	@Override
	public ResponseEntity<String> getCountWithWebClient(String startTime, String endTime) {
		
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		
		ResponseEntity<String> count  = webClient.get()
				.uri(countUrl, paramMap)
				/*.exchangeToMono(response -> {
			         if (response.statusCode().equals(HttpStatus.OK)) {
			             return response.bodyToMono(String.class);
			         }
			         else {
			             return response.createError();
			         }
			     });*/
		
				.retrieve()				
				//.bodyToMono(String.class)
				.toEntity(String.class)
				.block();
		return count;
	}

	@Override
	public String getUsgsData(String startTime, String endTime, Integer minMagnitude) {
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		paramMap.put("minMagnitude", minMagnitude);
		
		usgsData = restTemplate.getForEntity(USGS_QUERY_URL, String.class, paramMap);
		
		return usgsData.getBody();
	}
	
	
}
