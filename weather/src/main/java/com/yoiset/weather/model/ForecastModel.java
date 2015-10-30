package com.yoiset.weather.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ForecastModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String zipcode;
	private String state;
	private String ciry;
	private List<ForecastContent> contents;
	private String message;
	

	public ForecastModel() {
		contents = new ArrayList<ForecastContent>();
	}
	
	public ForecastModel(String zipcode,String message) {
		contents = new ArrayList<ForecastContent>();
		this.message = message;
		this.zipcode = zipcode;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCiry() {
		return ciry;
	}

	public void setCiry(String ciry) {
		this.ciry = ciry;
	}

	public List<ForecastContent> getContents() {
		return contents;
	}

	public void setContents(List<ForecastContent> contents) {
		this.contents = contents;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	

}
