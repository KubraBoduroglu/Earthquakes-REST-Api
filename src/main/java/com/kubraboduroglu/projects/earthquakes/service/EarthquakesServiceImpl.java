package com.kubraboduroglu.projects.earthquakes.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class EarthquakesServiceImpl implements EarthquakesService{

	RestTemplate restTemplate = new RestTemplate();
	private static final String USGS_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";
	private static final String countUrl = "https://earthquake.usgs.gov/fdsnws/event/1/count?starttime={starttime}&endtime={endtime}";
	
	Map<String, String> paramMap = new HashMap<>();
	
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
	public Mono<String> getCountWithWebClient(String startTime, String endTime) {
		
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		
		Mono<String> count = webClient.get()
				.uri(countUrl, paramMap)
				.retrieve()
				.bodyToMono(String.class);
				//.block();
		return count;
	}
	
	
}
