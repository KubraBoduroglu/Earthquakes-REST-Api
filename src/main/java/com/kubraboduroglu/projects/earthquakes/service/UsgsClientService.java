package com.kubraboduroglu.projects.earthquakes.service;

import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Mono;

public interface UsgsClientService {

	String getCountObject(String startTime, String endTime);
	ResponseEntity<String> getCountEntity(String startTime, String endTime);
	ResponseEntity<String> getCountWithWebClient(String startTime, String endTime);
	String getUsgsData(String startTime, String endTime, Integer minMagnitude);
}
