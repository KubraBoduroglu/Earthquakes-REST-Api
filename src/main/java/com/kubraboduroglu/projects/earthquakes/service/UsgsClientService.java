package com.kubraboduroglu.projects.earthquakes.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;

import reactor.core.publisher.Mono;

public interface UsgsClientService {

	String getCountObject(String startTime, String endTime);
	ResponseEntity<String> getCountEntity(String startTime, String endTime);
	ResponseEntity<String> getCountWithWebClient(String startTime, String endTime);
	ResponseEntity<String> getUsgsData(String startTime, String endTime, Double minMagnitude);
	UsgsResponseDTO getUsgsDatav2(String startTime, String endTime, Double minMagnitude);
}
