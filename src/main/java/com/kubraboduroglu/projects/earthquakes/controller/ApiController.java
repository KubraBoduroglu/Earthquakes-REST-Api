package com.kubraboduroglu.projects.earthquakes.controller;

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
	
	@GetMapping("/allData")
	public ResponseEntity<String> getData(){
		return new ResponseEntity<String>("allData", HttpStatus.OK);		
	}
	
	@PostMapping("/Data")
	public ResponseEntity<String> createData(@RequestBody UsgsQueryReqDTO usgsQueryReqDto){
		
		return new ResponseEntity<String>("Data", HttpStatus.OK);	
	}

}
