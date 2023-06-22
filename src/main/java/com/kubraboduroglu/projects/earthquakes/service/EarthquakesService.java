package com.kubraboduroglu.projects.earthquakes.service;

import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Mono;

public interface EarthquakesService {

	String getCountObject(String startTime, String endTime);
	ResponseEntity<String> getCountEntity(String startTime, String endTime);
	Mono<String> getCountWithWebClient(String startTime, String endTime);
}
