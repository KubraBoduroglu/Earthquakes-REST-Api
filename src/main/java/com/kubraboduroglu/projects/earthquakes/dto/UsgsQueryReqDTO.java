package com.kubraboduroglu.projects.earthquakes.dto;

public class UsgsQueryReqDTO {
	
	private String starttime;
	private String endtime;
	private Integer minmagnitude;
	private Integer maxmagnitude;
	
	public UsgsQueryReqDTO(String starttime, String endtime, Integer minmagnitude, Integer maxmagnitude) {
		super();
		this.starttime = starttime;
		this.endtime = endtime;
		this.minmagnitude = minmagnitude;
		this.maxmagnitude = maxmagnitude;
	}

	public UsgsQueryReqDTO() {
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
