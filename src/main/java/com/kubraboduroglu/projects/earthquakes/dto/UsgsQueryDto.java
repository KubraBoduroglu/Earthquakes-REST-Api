package com.kubraboduroglu.projects.earthquakes.dto;

public class UsgsQueryDto {
	
	String starttime;
	String endtime;
	Integer minmagnitude;
	Integer maxmagnitude;
	
	public UsgsQueryDto(String starttime, String endtime, Integer minmagnitude, Integer maxmagnitude) {
		super();
		this.starttime = starttime;
		this.endtime = endtime;
		this.minmagnitude = minmagnitude;
		this.maxmagnitude = maxmagnitude;
	}

	public UsgsQueryDto() {
		super();
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getMinmagnitude() {
		return minmagnitude;
	}

	public void setMinmagnitude(Integer minmagnitude) {
		this.minmagnitude = minmagnitude;
	}

	public Integer getMaxmagnitude() {
		return maxmagnitude;
	}

	public void setMaxmagnitude(Integer maxmagnitude) {
		this.maxmagnitude = maxmagnitude;
	}
	
	

}
