package com.kubraboduroglu.projects.earthquakes.service;

import java.util.HashMap;
import java.util.Map;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;
import com.kubraboduroglu.projects.earthquakes.repository.UsgsDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;

@Service
public class ApiServiceImpl implements ApiService{

	Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);
	@Autowired
	private UsgsClientService earthquakesService;
	@Autowired
	private UsgsDataRepository usgsDataRepository;
	RestTemplate restTemplate = new RestTemplate();
	Map<String, Object> paramMap = new HashMap<>();

	public UsgsResponseDTO createData(UsgsQueryReqDTO usgsQueryReqDto) {
		// TODO add validation
		String startTime = usgsQueryReqDto.getStarttime();
		String endTime = usgsQueryReqDto.getEndtime();
		Integer minMagnitude = usgsQueryReqDto.getMinmagnitude();

		logger.info("INFO Message: ApiServiceImpl.createData method called");
		UsgsResponseDTO usgsResponseDTO = earthquakesService.getUsgsDatav2(startTime,endTime, minMagnitude);

		// TODO add to db
		// usgsDataRepository.save(usgsResponseDTO);
		return usgsResponseDTO;
	}

}
