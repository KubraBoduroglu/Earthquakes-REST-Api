package com.kubraboduroglu.projects.earthquakes.service;

import org.springframework.http.ResponseEntity;

public interface EarthquakesService {

	String getCountv1(String startTime, String endTime);
	ResponseEntity<String> getCountv2(String startTime, String endTime);
}
