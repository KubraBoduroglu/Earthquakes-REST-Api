package com.kubraboduroglu.projects.earthquakes.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.kubraboduroglu.projects.earthquakes.dto.Feature;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;
import com.kubraboduroglu.projects.earthquakes.model.UsgsData;
import com.kubraboduroglu.projects.earthquakes.repository.UsgsDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService{

	Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);
	@Autowired
	private UsgsClientService earthquakesService;
	@Autowired
	private UsgsDataRepository usgsDataRepository;
	RestTemplate restTemplate = new RestTemplate();
	Map<String, Object> paramMap = new HashMap<>();
	private static final String format = "geojson";
	private static final String CLIENT_API_URL="http://localhost:8080/ApiController/v1/getUsgsDataByEventId";

	public UsgsData createData(UsgsQueryReqDTO usgsQueryReqDTO) {
		String startTime = usgsQueryReqDTO.getStarttime();
		String endTime = usgsQueryReqDTO.getEndtime();
		String eventId = usgsQueryReqDTO.getEventId();
		paramMap.put("starttime", startTime);
		paramMap.put("endtime", endTime);
		paramMap.put("eventId", eventId);
		paramMap.put("format", format);
		logger.info("INFO Message: ApiServiceImpl.createData method calling");
		// TODO what is the return type to query with eventId -> Feature
		Feature feature = restTemplate.getForEntity(CLIENT_API_URL, Feature.class, paramMap).getBody();
		logger.info("INFO Message: ApiServiceImpl.createData method called");

		List<UsgsData> existingDataList = usgsDataRepository.findByEventId(feature.getId());
		if (!existingDataList.isEmpty()) {
            throw new RuntimeException("There is a record with the same eventId.");
        } else {
            UsgsData usgsData = new UsgsData();
            usgsData.setEventId(feature.getId());
			// TODO how to do that with JsonNode
			// usgsData.setMagnitude(feature.getProperties().getMag());
			usgsData.setMagnitude(feature.getProperties().get("mag").asInt());
			usgsData.setPlace(feature.getProperties().get("place").asText());
			usgsData.setTime(feature.getProperties().get("time").asText());
            return usgsDataRepository.save(usgsData);
        }
    }

	@Override
	public List<UsgsData> getAllUsgsData() {
		return usgsDataRepository.findAll();
	}

	@Override
	public Optional<UsgsData> getUsgsDataById(Long usgsDataId) {
		return usgsDataRepository.findById(usgsDataId);
	}

	@Override
	public UsgsData updateUsgsData(Long usgsDataId, UsgsData usgsData) {
		// TODO
		return null;
	}

	@Override
	public void deleteUsgsData(Long usgsDataId) {
		usgsDataRepository.deleteById(usgsDataId);
	}

}
