package com.kubraboduroglu.projects.earthquakes.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/EarthquakesApi")
public class EarthquakesController {
	
	RestTemplate restTemplate = new RestTemplate();
	private static final String USGS_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";
	
	Map<String, String> paramMap = new HashMap<>();
	
	@GetMapping("/getVersionNo")
	public ResponseEntity<String> getVersionNo() {
		String versionNo = restTemplate.getForObject(USGS_URL + "version", String.class);
		System.out.println("versionNo: " + versionNo);
		return new ResponseEntity<String>(versionNo, HttpStatus.OK);
	}
	
	@GetMapping("/getCount")
	public ResponseEntity<String> getCount(){
		//paramMap.put("starttime", "2023-01-01");
		//paramMap.put("endtime", endTime);
		
		String countUrl = "https://earthquake.usgs.gov/fdsnws/event/1/count";
		
		//ResponseEntity<String> count = restTemplate.getForEntity(countUrl, String.class, paramMap);
		String count = restTemplate.getForObject(countUrl, String.class, paramMap);
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
	
}
