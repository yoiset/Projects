package com.yoiset.weather.service;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weather.wsdl.Forecast;
import weather.wsdl.ForecastReturn;
import weather.wsdl.GetCityForecastByZIPResponse;
import weather.wsdl.Temp;

import com.yoiset.weather.model.ForecastContent;
import com.yoiset.weather.model.ForecastModel;
import com.yoiset.weather.ws.WeatherClient;

@Service("service")
public class HomeService {
	
	private final Logger logger = LoggerFactory.getLogger(HomeService.class);

	@Autowired
	private WeatherClient weatherClient;

	public HomeService() {
		// TODO Auto-generated constructor stub
	}

	public void setWeatherClient(WeatherClient weatherClient) {
		this.weatherClient = weatherClient;
	}

	/**Return a Forecast given a zip code. Here we call the Weather Service Client
	 * @param zipCode
	 * @return
	 */
	public ForecastModel getWeatherByZip(String zipCode) {

		GetCityForecastByZIPResponse response = weatherClient
				.getCityForecastByZip(zipCode);

		ForecastModel model= generateWeather(response);
		model.setZipcode(zipCode);
		return model;
		
		
	}

	/** Transform a Response Weather object to Forecast Model handled at Spring Controller layer
	 * @param response
	 * @return
	 */
	private ForecastModel generateWeather(GetCityForecastByZIPResponse response) {

		ForecastReturn forecastReturn = response
				.getGetCityForecastByZIPResult();
		
		ForecastModel model=new ForecastModel();

		if (forecastReturn.isSuccess()) {
			
			model.setState(forecastReturn.getState());
			model.setCiry(forecastReturn.getCity());

			SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");
			
			for (Forecast forecast : forecastReturn.getForecastResult().getForecast()) {
				
				ForecastContent content=new ForecastContent();
				
//				content.setDate(format.format(forecast.getDate().toGregorianCalendar()));
//				content.setTime(format.format(forecast.getDate().toGregorianCalendar().getTime()));
				content.setDescription(forecast.getDesciption());
				
				Temp temperature = forecast.getTemperatures();
				
				content.setMorningLow(temperature.getMorningLow());
				content.setDaytimeHigh(temperature.getDaytimeHigh());
				
				model.getContents().add(content);
			}
		} else 
			logger.error("No forecast received");
			
		
		
		return model;
	}

}
