package com.kubraboduroglu.projects.earthquakes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ApiController/v1")
public class ApiController {
	
	@GetMapping("/getData")
	public ResponseEntity<String> getData(){
		return new ResponseEntity<String>("getData", HttpStatus.OK);		
	}

}
