package com.kubraboduroglu.projects.earthquakes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UsgsClientService {

    String getCountObject(String startTime, String endTime);

    ResponseEntity<String> getCountEntity(String startTime, String endTime);

    ResponseEntity<String> getCountWithWebClient(String startTime, String endTime);

    String getUsgsData(String startTime, String endTime, Integer minMagnitude);

    //String getUsgsDatav2(String startTime, String endTime, Integer minMagnitude);
    UsgsResponseDTO getUsgsDatav2(UsgsQueryReqDTO usgsQueryReqDto) throws JsonProcessingException;
}
