package com.kubraboduroglu.projects.earthquakes.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;
import com.kubraboduroglu.projects.earthquakes.model.UsgsData;
import com.kubraboduroglu.projects.earthquakes.repository.UsgsDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	public UsgsData createData(UsgsData usgsData) {
		String startTime = usgsData.getStartTime();
		String endTime = usgsData.getEndTime();
		Integer minMagnitude = usgsData.getMagnitude();
		String place = usgsData.getPlace();

		logger.info("INFO Message: ApiServiceImpl.createData method calling");
		UsgsResponseDTO usgsResponseDTO = earthquakesService.getUsgsDatav2(startTime,endTime, minMagnitude);
		logger.info("INFO Message: ApiServiceImpl.createData method called");

		// TODO add validate method
		return usgsDataRepository.save(usgsData);
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
