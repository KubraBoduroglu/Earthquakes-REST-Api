package com.kubraboduroglu.projects.earthquakes.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;

import reactor.core.publisher.Mono;

@Service
public class UsgsClientServiceImpl implements UsgsClientService{

	// TODO: create properties file for urls etc
	
	RestTemplate restTemplate = new RestTemplate();
	private static final String USGS_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";
	private static final String countUrl = "https://earthquake.usgs.gov/fdsnws/event/1/count?starttime={starttime}&endtime={endtime}";
	private static final String USGS_QUERY_URL="https://earthquake.usgs.gov/fdsnws/event/1/query";
	
	Map<String, Object> paramMap = new HashMap<>();
	ResponseEntity<String> usgsData;
	
	//WebClient client = WebClient.create();
	WebClient webClient = WebClient.builder()
		    .baseUrl("http://localhost:8080")
		    .build();
	
	public String getCountObject(String startTime, String endTime) {
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
				
		String count = restTemplate.getForObject(countUrl, String.class, paramMap);
		return count;
	}
	
	public ResponseEntity<String> getCountEntity(String startTime, String endTime) {
		
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
				
		ResponseEntity<String> count = restTemplate.getForEntity(countUrl, String.class, paramMap);
		return count;
	}

	@Override
	public ResponseEntity<String> getCountWithWebClient(String startTime, String endTime) {
		
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		
		ResponseEntity<String> count  = webClient.get()
				.uri(countUrl, paramMap)
				/*.exchangeToMono(response -> {
			         if (response.statusCode().equals(HttpStatus.OK)) {
			             return response.bodyToMono(String.class);
			         }
			         else {
			             return response.createError();
			         }
			     });*/
		
				.retrieve()				
				//.bodyToMono(String.class)
				.toEntity(String.class)
				.block();
		return count;
	}

	@Override
	public String getUsgsData(String startTime, String endTime, Integer minMagnitude) {
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		paramMap.put("minMagnitude", minMagnitude);
		
		usgsData = restTemplate.getForEntity(USGS_QUERY_URL, String.class, paramMap);
		
		return usgsData.getBody();
	}
	
	@Override
	public UsgsResponseDTO[] getUsgsDatav2(UsgsQueryReqDTO usgsQueryReqDto) throws JsonMappingException, JsonProcessingException {
		paramMap.put("starttime", usgsQueryReqDto.getStarttime());
		paramMap.put("endtime", usgsQueryReqDto.getEndtime());
		paramMap.put("minMagnitude", usgsQueryReqDto.getMinmagnitude());
		
		ResponseEntity<UsgsResponseDTO[]> usgsResponseData;
		usgsResponseData = restTemplate.getForEntity(USGS_QUERY_URL, UsgsResponseDTO[].class, paramMap);
		
		ObjectMapper mapper = new ObjectMapper();
		//usgsData = mapper.readValue(USGS_QUERY_URL, ParameterizedTypeReference<List<E>>);
		//usgsResponseData = mapper.readValue(USGS_QUERY_URL, UsgsResponseDTO.class);
		//usgsResponseData.usgsResponseData.getBody()
		
		return usgsResponseData.getBody();
	}
	
	
}
