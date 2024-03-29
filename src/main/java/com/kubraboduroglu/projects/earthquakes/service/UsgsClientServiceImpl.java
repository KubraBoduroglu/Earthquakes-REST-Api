package com.kubraboduroglu.projects.earthquakes.service;

import java.util.HashMap;
import java.util.Map;

import com.kubraboduroglu.projects.earthquakes.dto.Feature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;

@Service
public class UsgsClientServiceImpl implements UsgsClientService{

	// TODO: create properties file for urls etc
	
	RestTemplate restTemplate = new RestTemplate();
	private static final String countUrl = "https://earthquake.usgs.gov/fdsnws/event/1/count?starttime={starttime}&endtime={endtime}";
	private static final String USGS_QUERY_URL="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson";
	private static final String format = "geojson";
	
	Map<String, Object> paramMap = new HashMap<>();
	ResponseEntity<String> usgsData;
	
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
	public ResponseEntity<String> getUsgsData(String startTime, String endTime, Double minMagnitude) {
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		paramMap.put("minMagnitude", minMagnitude);
		paramMap.put("format", format);
		usgsData = restTemplate.getForEntity(USGS_QUERY_URL, String.class, paramMap);
		// with getForObject:
		// UsgsResponseDTO usgsResponseData;
		// ObjectMapper mapper = new ObjectMapper();
		// JsonNode root = mapper.readTree(usgsData.getBody());
		return usgsData;
	}
	
	@Override
	// List<UsgsResponseDTO>
	public UsgsResponseDTO getUsgsDatav2(String startTime, String endTime, Integer minMagnitude) {
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		paramMap.put("minMagnitude", minMagnitude);
		paramMap.put("format", format); 

		ResponseEntity<UsgsResponseDTO> usgsResponseData;
		usgsResponseData = restTemplate.getForEntity(USGS_QUERY_URL, UsgsResponseDTO.class, paramMap);
		
		return usgsResponseData.getBody();
		//ObjectMapper mapper = new ObjectMapper();
		//usgsData = mapper.readValue(USGS_QUERY_URL, ParameterizedTypeReference<List<E>>);
		//usgsResponseData = mapper.readValue(USGS_QUERY_URL, UsgsResponseDTO.class);
		//usgsResponseData.usgsResponseData.getBody();

	}

	@Override
	public Feature getUsgsDataByEventId(String startTime, String endTime, String eventId) {
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		paramMap.put("eventId", eventId);
		paramMap.put("format", format);
		ResponseEntity<Feature> usgsResponseFeature;
		usgsResponseFeature = restTemplate.getForEntity(USGS_QUERY_URL, Feature.class, paramMap);
		return usgsResponseFeature.getBody();
	}


}
