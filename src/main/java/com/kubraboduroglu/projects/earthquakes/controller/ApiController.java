package com.kubraboduroglu.projects.earthquakes.controller;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;
import com.kubraboduroglu.projects.earthquakes.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;

@RestController
@RequestMapping("/ApiController/v1")
public class ApiController {
	
	Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping("/allData")
	public ResponseEntity<String> getAllData(){
		return new ResponseEntity<String>("allData", HttpStatus.OK);		
	}

	@GetMapping("/Datas")
	public ResponseEntity<String> getData(){
		return new ResponseEntity<String>("Data", HttpStatus.OK);
	}
	
	@PostMapping("/Data")
	public ResponseEntity<String> createData(@RequestBody UsgsQueryReqDTO usgsQueryReqDto){
		logger.info("INFO Message: ApiController.createData method called");
		UsgsResponseDTO data = apiService.createData(usgsQueryReqDto);
		return new ResponseEntity<String>("Data", HttpStatus.OK);	
	}

}
