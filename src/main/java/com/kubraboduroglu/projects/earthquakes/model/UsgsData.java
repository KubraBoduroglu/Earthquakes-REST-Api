package com.kubraboduroglu.projects.earthquakes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsgsData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USGS_ID")
	private Long usgsDataId;

	@Column(name="EVENT_ID")
	private  String eventId;

	@Column(name="START_TIME")
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	//	@Column(name="START_TIME")
//	private String startTime;
//
//	@Column(name="END_TIME")
//	private String endTime;
	
	@Column(name="MAGNITUDE")
	private Integer magnitude;
	
	@Column(name="PLACE")
	private String place;

	public Long getUsgsDataId() {
		return usgsDataId;
	}

	public void setUsgsDataId(Long usgsDataId) {
		this.usgsDataId = usgsDataId;
	}

//	public String getStartTime() {
//		return startTime;
//	}
//
//	public void setStartTime(String startTime) {
//		this.startTime = startTime;
//	}
//
//	public String getEndTime() {
//		return endTime;
//	}
//
//	public void setEndTime(String endTime) {
//		this.endTime = endTime;
//	}

	public Integer getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(Integer magnitude) {
		this.magnitude = magnitude;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "UsgsData [usgsId=" + usgsDataId + ", time=" + time + ", magnitude="
				+ magnitude + ", place=" + place + "]";
	}


	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
}
