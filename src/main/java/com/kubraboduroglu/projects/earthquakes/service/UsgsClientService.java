package com.kubraboduroglu.projects.earthquakes.service;

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
	String getUsgsData(String startTime, String endTime, Integer minMagnitude);
	//String getUsgsDatav2(String startTime, String endTime, Integer minMagnitude);
	UsgsResponseDTO[] getUsgsDatav2(UsgsQueryReqDTO usgsQueryReqDto) throws JsonMappingException, JsonProcessingException;
}
