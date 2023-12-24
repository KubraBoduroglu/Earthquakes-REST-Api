package com.kubraboduroglu.projects.earthquakes.dto;

public class UsgsQueryReqDTO {
	
	private String starttime;
	private String endtime;
	private Integer minmagnitude;
	private Integer maxmagnitude;
	private String eventId;
	//private String format = "geojson";
	
	public UsgsQueryReqDTO(String starttime, String endtime, Integer minmagnitude, Integer maxmagnitude, String eventId/*,
			String format*/) {
		super();
		this.starttime = starttime;
		this.endtime = endtime;
		this.minmagnitude = minmagnitude;
		this.maxmagnitude = maxmagnitude;
		//this.format = format;
        this.eventId = eventId;
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

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	/*public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}*/
	
	

}
