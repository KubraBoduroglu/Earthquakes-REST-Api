package com.kubraboduroglu.projects.earthquakes.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kubraboduroglu.projects.earthquakes.service.EarthquakesService;

@RestController
@RequestMapping("/EarthquakesApi")
public class EarthquakesController {
	
	@Autowired
	private EarthquakesService earthquakesService;
	
	RestTemplate restTemplate = new RestTemplate();
	private static final String USGS_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";
	
	Map<String, String> paramMap = new HashMap<>();
	
	@GetMapping("/getVersionNo")
	public ResponseEntity<String> getVersionNo() {
		String versionNo = restTemplate.getForObject(USGS_URL + "version", String.class);
		return new ResponseEntity<String>(versionNo, HttpStatus.OK);
	}
	
	@GetMapping("/getCountv1")
	public ResponseEntity<String> getCountv1(String startTime, String endTime){
		String count = earthquakesService.getCountv1(startTime, endTime);
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
	
	/**
	 * @param startTime
	 * @return
	 */
	@GetMapping("/getCountv2")
	public ResponseEntity<String> getCountv2(String startTime, String endTime){
		
		ResponseEntity<String> count = earthquakesService.getCountv2(startTime,endTime);
		return count;
	}
	
}
