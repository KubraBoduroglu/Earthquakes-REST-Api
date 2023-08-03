package com.kubraboduroglu.projects.earthquakes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UsgsData {

	@Id
	private Long id;
	
	private String startTime;
	
	private String endTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
