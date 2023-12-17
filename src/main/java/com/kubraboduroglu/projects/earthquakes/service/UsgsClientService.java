package com.kubraboduroglu.projects.earthquakes.service;

import org.springframework.http.ResponseEntity;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;

public interface UsgsClientService {

	String getCountObject(String startTime, String endTime);
	ResponseEntity<String> getCountEntity(String startTime, String endTime);
	ResponseEntity<String> getCountWithWebClient(String startTime, String endTime);
	ResponseEntity<String> getUsgsData(String startTime, String endTime, Double minMagnitude);
	UsgsResponseDTO getUsgsDatav2(String startTime, String endTime, Integer minMagnitude);
}
