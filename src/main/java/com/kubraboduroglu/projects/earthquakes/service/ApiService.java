package com.kubraboduroglu.projects.earthquakes.service;

import com.kubraboduroglu.projects.earthquakes.model.UsgsData;

import java.util.List;
import java.util.Optional;

public interface ApiService {
    UsgsData createData(UsgsData usgsData);

    List<UsgsData> getAllUsgsData();

    Optional<UsgsData> getUsgsDataById(Long usgsDataId);

    UsgsData updateUsgsData(Long usgsDataId, UsgsData usgsData);

    void deleteUsgsData(Long usgsDataId);
}
