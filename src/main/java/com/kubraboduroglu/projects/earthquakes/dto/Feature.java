package com.kubraboduroglu.projects.earthquakes.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

	private String type;
	//private List<Property> properties = new ArrayList<>();
	private JsonNode properties;
	private JsonNode geometry; 
	private String id;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	 public JsonNode getProperties() {
		return properties;
	}
	public void setProperties(JsonNode properties) {
		this.properties = properties;
	}
	public JsonNode getGeometry() {
		return geometry;
	}
	public void setGeometry(JsonNode geometry) {
		this.geometry = geometry;
	} 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
