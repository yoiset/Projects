package com.yoiset.weather.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import weather.wsdl.GetCityForecastByZIP;
import weather.wsdl.GetCityForecastByZIPResponse;

public class WeatherClient extends WebServiceGatewaySupport {

	private final Logger logger = LoggerFactory.getLogger(WeatherClient.class);
	
	public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode) {
		
		GetCityForecastByZIP request = new GetCityForecastByZIP();
		request.setZIP(zipCode);

		
		logger.info("Requesting forecast for " + zipCode);

		GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate().marshalSendAndReceive(
				request,new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));

		return response;
	}

}
