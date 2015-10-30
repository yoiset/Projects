package com.yoiset.singup.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yoiset.signup.util.SupportController;
import com.yoiset.singup.service.SingUpService;

@Controller
public class SingUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(SingUpController.class);

	@Resource
	private SingUpService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model,  HttpServletRequest request) {
		
		String userName= request.getParameter("userName");
		if(userName == null || userName.isEmpty()){
			model.addAttribute("message", "Username can't be empty" );
			return "login";
		}
		
		if(service.getResgisterUsers().get(userName) == null){
			model.addAttribute("message", "Username doesn't exist" );
			return "login";
		}
		
		model.addAttribute("question", service.getQuestion(userName));
		model.addAttribute("userName", userName);
		
		return "securityQuestion";
	}
	
	@RequestMapping(value = "validateQuestion", method = RequestMethod.POST)
	public String validateAnswer(Model model,  HttpServletRequest request){
		
		String userName= request.getParameter("userName");
		String question= request.getParameter("question");
		String response= request.getParameter("response");
		
		model.addAttribute("userName", userName);
		model.addAttribute("question", question);
		
		if(response == null || response.isEmpty()){
			model.addAttribute("message", "Answer  can't be empy" );
			return "securityQuestion";
		}
			
		if(service.isValidAnswer(userName, question, response)){
			model.addAttribute("message", "Login Success " );
			return "home";
		}
		else  model.addAttribute("message", "Login fail " );
			
	   return "securityQuestion";
	}
	
	
	
	@RequestMapping(value = "singup", method = RequestMethod.GET)
	public String signup(Model model) {
		
		return "singup"; 
	}
	
	@RequestMapping(value = "loginAction", method = RequestMethod.GET)
	public String loginAction(Model model) {
		
		return "login"; 
	}
	
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model,  HttpServletRequest request) {
		
		String userName= request.getParameter("userName");
		String dob= request.getParameter("dob");
		
		if(service == null) return "error";
		
		if(userName== null || dob == null || userName.isEmpty() || dob.isEmpty()) {
			model.addAttribute("message", "All fields must be fill out" );
			return "singup";
		}
		
		if(service.existUser(userName)){
			model.addAttribute("message", "User name already exists" );
			return "singup";
		}
		
		try {
			service.addUser(userName, dob);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			model.addAttribute("message", "Please, make sure DOB contain this format MM/dd/YYYY" );
			return "singup";
		}
		
		model.addAttribute("userName", userName );
		
		model.addAttribute("quetionList1", SupportController.generateQuetion().get(1));
		model.addAttribute("quetionList2", SupportController.generateQuetion().get(2));
		model.addAttribute("quetionList3", SupportController.generateQuetion().get(3));
		return "quetions"; 
	}
	
	@RequestMapping(value = "registerQuetions", method = RequestMethod.GET)
	public String quetions(Model model,  HttpServletRequest request){
		
		String userName= request.getParameter("userName");
		
		String q1= request.getParameter("quetion1");
		String r1= request.getParameter("response1");
		
		String q2= request.getParameter("quetion2");
		String r2= request.getParameter("response2");
		
		
		String q3= request.getParameter("quetion3");
		String r3= request.getParameter("response3");
		
		if(SupportController.isInvalidQA(q1,q2,q3,r1,r2,r3)){
			model.addAttribute("message", "All fields must be filled out" );
			model.addAttribute("userName", userName );
			model.addAttribute("quetionList1", SupportController.generateQuetion().get(1));
			model.addAttribute("quetionList2", SupportController.generateQuetion().get(2));
			model.addAttribute("quetionList3", SupportController.generateQuetion().get(3));
			return "quetions"; 
		}
		
		service.addQA(userName, q1,q2,q3,r1,r2,r3);
		
		return "home";
	}

	public void setService(SingUpService service) {
		this.service = service;
	}

}
