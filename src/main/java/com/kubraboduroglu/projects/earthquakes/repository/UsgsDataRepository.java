package com.kubraboduroglu.projects.earthquakes.repository;

import com.kubraboduroglu.projects.earthquakes.model.UsgsData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsgsDataRepository extends JpaRepository<UsgsData, Long> {
}
