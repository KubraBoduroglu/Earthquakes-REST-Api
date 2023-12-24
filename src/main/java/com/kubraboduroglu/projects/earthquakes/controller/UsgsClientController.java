package com.kubraboduroglu.projects.earthquakes.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kubraboduroglu.projects.earthquakes.dto.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;
import com.kubraboduroglu.projects.earthquakes.service.UsgsClientService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/UsgsClient")
public class UsgsClientController {
	
	Logger logger = LoggerFactory.getLogger(UsgsClientController.class);
	
	@Autowired
	private UsgsClientService earthquakesService;
	
	RestTemplate restTemplate = new RestTemplate();
	private static final String USGS_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";
	
	Map<String, String> paramMap = new HashMap<>();
	String usgsData;
		
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
	
	@GetMapping("/getCountEntity")
	public ResponseEntity<String> getCountEntity(String startTime, String endTime){
		
		ResponseEntity<String> count = earthquakesService.getCountEntity(startTime,endTime);
		return count;
	}
	
	// TODO can try feign client too
	@GetMapping("/getCountWithWebClient")
	public ResponseEntity<ResponseEntity<String>> getCountWithWebClient(String startTime, String endTime, Integer minMagnitude){
		logger.info("INFO Message: logger.info(\"INFO Message: getUsgsDatav2 method called\"); method called");
		ResponseEntity<String> count = earthquakesService.getCountWithWebClient(startTime,endTime);
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
	
	@GetMapping("/getUsgsData/v1")
	public ResponseEntity<String> getUsgsData(@RequestParam String startTime, @RequestParam String endTime, @RequestParam Double minMagnitude){
		logger.info("INFO Message: getUsgsData method called");
		ResponseEntity<String> usgsData = earthquakesService.getUsgsData(startTime,endTime, minMagnitude);
		return usgsData;	
	}
	
	 @GetMapping("/getUsgsData/v2")
	 // TODO can try with List<Features> 
	public UsgsResponseDTO getUsgsDatav2(@RequestParam String startTime, @RequestParam String endTime, @RequestParam Integer minMagnitude) {
		logger.info("INFO Message: getUsgsDatav2 method called");
		UsgsResponseDTO usgsResponseDTO = earthquakesService.getUsgsDatav2(startTime,endTime, minMagnitude);
		return usgsResponseDTO;
	}

	@GetMapping("/getUsgsDataByEventId")
	public Feature getUsgsDataByEventId(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String eventId) {
		// TODO add optional parameters like place and magnitude
		logger.info("INFO Message: getUsgsDatav2 method called");
		Feature feature = earthquakesService.getUsgsDataByEventId(startTime,endTime, eventId);
		return feature;
	}

}
