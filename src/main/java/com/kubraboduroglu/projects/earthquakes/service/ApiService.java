package com.kubraboduroglu.projects.earthquakes.service;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;
import com.kubraboduroglu.projects.earthquakes.dto.UsgsResponseDTO;

public interface ApiService {
    UsgsResponseDTO createData(UsgsQueryReqDTO usgsQueryReqDto);
}
