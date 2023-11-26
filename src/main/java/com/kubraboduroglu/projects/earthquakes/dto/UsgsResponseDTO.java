package com.kubraboduroglu.projects.earthquakes.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsgsResponseDTO {

	private String type;
	//private Metadata metadata;
	private List<Feature> features = new ArrayList<>();
	private Long[] bbox;
	
	@Override
	public String toString() {
		return "UsgsResponseDTO [type=" + type + ", features=" + features + ", bbox=" + Arrays.toString(bbox) + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
	public Long[] getBbox() {
		return bbox;
	}
	public void setBbox(Long[] bbox) {
		this.bbox = bbox;
	}
}
