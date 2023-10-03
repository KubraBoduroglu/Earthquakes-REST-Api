package com.kubraboduroglu.projects.earthquakes.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;
import com.kubraboduroglu.projects.earthquakes.service.UsgsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/UsgsClient")
public class UsgsClientController {

    @Autowired
    private UsgsClientService earthquakesService;

    RestTemplate restTemplate = new RestTemplate();
    private static final String USGS_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";

    String usgsData;

    @GetMapping("/getVersionNo")
    public ResponseEntity<String> getVersionNo() {
        String versionNo = restTemplate.getForObject(USGS_URL + "version", String.class);
        return new ResponseEntity<>(versionNo, HttpStatus.OK);
    }

    @GetMapping("/getCountObject")
    public ResponseEntity<String> getCountObject(String startTime, String endTime) {
        String count = earthquakesService.getCountObject(startTime, endTime);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/getCountEntity")
    public ResponseEntity<String> getCountEntity(String startTime, String endTime) {

        ResponseEntity<String> count = earthquakesService.getCountEntity(startTime, endTime);
        return count;
    }

    // not working for now, research more about synchronous call with WebClient and reactive programming
    //can try feign client too
    @GetMapping("/getCountWithWebClient")
    public ResponseEntity<ResponseEntity<String>> getCountWithWebClient(String startTime, String endTime, Integer minMagnitude) {
        ResponseEntity<String> count = earthquakesService.getCountWithWebClient(startTime, endTime);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/getUsgsData/v1")
    public ResponseEntity<String> getUsgsData(@RequestParam String startTime, @RequestParam String endTime, @RequestParam Integer minMagnitude) {
        usgsData = earthquakesService.getUsgsData(startTime, endTime, minMagnitude);
        return new ResponseEntity<>(usgsData, HttpStatus.OK);
    }

    @GetMapping("/getUsgsData/v2")
    public ResponseEntity<UsgsResponseDTO> getUsgsDatav2(@RequestBody UsgsQueryReqDTO usgsQueryReqDto) throws JsonProcessingException {
        UsgsResponseDTO response = earthquakesService.getUsgsDatav2(usgsQueryReqDto);

        return ResponseEntity.ok(response);
    }

}
