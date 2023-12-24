package com.kubraboduroglu.projects.earthquakes.service;

import com.kubraboduroglu.projects.earthquakes.dto.UsgsQueryReqDTO;
import com.kubraboduroglu.projects.earthquakes.model.UsgsData;

import java.util.List;
import java.util.Optional;

public interface ApiService {
    UsgsData createData(UsgsQueryReqDTO usgsQueryReqDTO);

    List<UsgsData> getAllUsgsData();

    Optional<UsgsData> getUsgsDataById(Long usgsDataId);

    UsgsData updateUsgsData(Long usgsDataId, UsgsData usgsData);

    void deleteUsgsData(Long usgsDataId);
}
