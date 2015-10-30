package com.yoiset.weather.model;

import java.io.Serializable;

public class ForecastContent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String date;
	private String time;
	private String description;
	private String morningLow;
	private String daytimeHigh;

	public ForecastContent() {
		// TODO Auto-generated constructor stub
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMorningLow() {
		return morningLow;
	}

	public void setMorningLow(String morningLow) {
		this.morningLow = morningLow;
	}

	public String getDaytimeHigh() {
		return daytimeHigh;
	}

	public void setDaytimeHigh(String daytimeHigh) {
		this.daytimeHigh = daytimeHigh;
	}

}
