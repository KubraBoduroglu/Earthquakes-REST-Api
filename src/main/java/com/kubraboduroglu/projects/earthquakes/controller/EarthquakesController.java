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

import reactor.core.publisher.Mono;

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
	
	@GetMapping("/getCountObject")
	public ResponseEntity<String> getCountObject(String startTime, String endTime){
		String count = earthquakesService.getCountObject(startTime, endTime);
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
	
	/**
	 * @param startTime
	 * @return
	 */
	@GetMapping("/getCountEntity")
	public ResponseEntity<String> getCountEntity(String startTime, String endTime){
		
		ResponseEntity<String> count = earthquakesService.getCountEntity(startTime,endTime);
		return count;
	}
	
	@GetMapping("/getCountWithWebClient")
	public Mono<String> getCountWithWebClient(String startTime, String endTime){
		Mono<String> count = earthquakesService.getCountWithWebClient(startTime,endTime);
		return count;
	}
	
}
