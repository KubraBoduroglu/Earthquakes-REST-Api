package com.kubraboduroglu.projects.earthquakes.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;

@Service
public class ApiService {

	RestTemplate restTemplate = new RestTemplate();
	Map<String, Object> paramMap = new HashMap<>();

	public String createData(UsgsQueryReqDTO usgsQueryReqDto) {
		// TODO Auto-generated method stub
		paramMap.put("starttime", usgsQueryReqDto.getStarttime());
		paramMap.put("endtime", usgsQueryReqDto.getEndtime());
		paramMap.put("minMagnitude", usgsQueryReqDto.getMinmagnitude());
		return null;
	}

}
