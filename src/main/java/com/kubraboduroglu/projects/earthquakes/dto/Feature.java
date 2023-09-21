package com.kubraboduroglu.projects.earthquakes.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class Feature {

	private String type;
	//private List<Property> properties = new ArrayList<>();
	private JsonNode properties;
	private JsonNode geometry;
	private String id;
	
}
