package com.yoiset.weather.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yoiset.weather.model.ForecastModel;
import com.yoiset.weather.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource
	private HomeService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	/**
	 * @param zipcode
	 * @return
	 */
	@RequestMapping(value = "/forecast/{zipcode}", method = RequestMethod.POST)
	@ResponseBody
	public String getForeCast(@PathVariable("zipcode") String zipcode) {

		Gson gson = new Gson();

		List<ForecastModel> result = new ArrayList<ForecastModel>();

		List<String> zipList = parseParam(zipcode);

		for (String string : zipList)
			result.add(generateResponse(string));

		return gson.toJson(result);

	}

	/** Here we call the spring service weather by zipcode 
	 * @param zipcode
	 * @return
	 */
	private ForecastModel generateResponse(String zipcode) {
		try {
			return service.getWeatherByZip(zipcode);

		} catch (Exception e) {
			logger.error("Error invoking Web Service: ", e);
			return new ForecastModel(zipcode, "Error invoking Web Service");
		}
	}

	/** Method for handling and parsing zipcode string parameters. It can be a single zipcode or multiple zipcodes
	 * @param zipcode
	 * @return
	 */
	private List<String> parseParam(String zipcode) {
		
		List<String> zipList = new ArrayList<String>();

		if (zipcode.contains(",")) {
			
			StringTokenizer tokenizer = new StringTokenizer(zipcode.trim(), ",");
			while (tokenizer.hasMoreElements()) {
				String token = (String) tokenizer.nextElement();
				if(token !=null){
					StringBuilder element= new StringBuilder(token.replace(" ", "")) ;
					zipList.add(element.toString());
				}
				 
			}
		} else
			zipList.add(zipcode);

		return zipList;
	}

}
