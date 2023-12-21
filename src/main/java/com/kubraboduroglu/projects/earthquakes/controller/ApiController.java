package com.kubraboduroglu.projects.earthquakes.controller;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;
import com.kubraboduroglu.projects.earthquakes.model.UsgsData;
import com.kubraboduroglu.projects.earthquakes.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ApiController/v1")
public class ApiController {
	
	Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping("/data")
	public List<UsgsData> getAllData(){
		return apiService.getAllUsgsData();
		//return new ResponseEntity<String>("allData", HttpStatus.OK);
	}

	@GetMapping("/data/{usgsDataId}")
	public ResponseEntity<UsgsData> getData(@PathVariable Long usgsDataId){
		Optional<UsgsData> usgsDataById = apiService.getUsgsDataById(usgsDataId);
        return usgsDataById.map(usgsData -> new ResponseEntity<>(usgsData, HttpStatus.OK)).
				orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@PostMapping("/data")
	public ResponseEntity<UsgsData> createData(@RequestBody UsgsData usgsData){
		logger.info("INFO Message: ApiController.createData method called");
		UsgsData createdData = apiService.createData(usgsData);
		return new ResponseEntity<>(createdData, HttpStatus.CREATED);
	}

	@PutMapping("/{usgsDataId}")
	public  ResponseEntity<UsgsData> updateUsgsData(@PathVariable Long usgsDataId, @RequestBody UsgsData usgsData){
		UsgsData updatedUsgsData = apiService.updateUsgsData(usgsDataId, usgsData);
		if (updatedUsgsData != null) {
			return new ResponseEntity<>(updatedUsgsData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{meetingId}")
	public ResponseEntity<Void> deleteUsgsData(@PathVariable Long usgsDataId){
		// TODO if succesfull
		apiService.deleteUsgsData(usgsDataId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
