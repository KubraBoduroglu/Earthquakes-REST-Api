package com.kubraboduroglu.projects.earthquakes.repository;

import com.kubraboduroglu.projects.earthquakes.model.UsgsData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsgsDataRepository extends JpaRepository<UsgsData, Long> {
    List<UsgsData> findByEventId(String id);
}
