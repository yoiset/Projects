package com.yoiset.singup.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yoiset.singup.dto.User;

@Service(value = "service")
@Singleton
public class SingUpService {

	private static final Logger logger = LoggerFactory
			.getLogger(SingUpService.class);

	private HashMap<String, User> resgisterUsers;

	public SingUpService() {
		resgisterUsers = new HashMap<String, User>();
	}

	public HashMap<String, User> getResgisterUsers() {
		return resgisterUsers;
	}

	public void setResgisterUsers(HashMap<String, User> resgisterUsers) {
		this.resgisterUsers = resgisterUsers;
	}

	public void addUser(String userName, String dob) throws ParseException {

		SimpleDateFormat pattern = new SimpleDateFormat("MM/dd/YYYY");
		Date date = pattern.parse(dob);

		if (this.resgisterUsers.containsKey(userName))
			return;

		this.resgisterUsers.put(userName, new User(userName, date));

		logger.info("New User added. User Name: " + userName);
		logger.info("Resgister Users: " + this.resgisterUsers.size());

	}

	public boolean existUser(String userName) {
		return this.resgisterUsers.containsKey(userName);
	}

	public void addQA(String userName, String q1, String q2, String q3,
			String r1, String r2, String r3) {
		User user = resgisterUsers.get(userName);

		user.getQuetionAnswer().put(q1, r1);
		user.getQuetionAnswer().put(q2, r3);
		user.getQuetionAnswer().put(q3, r3);

	}

	public String getQuestion(String userName) {
		// TODO Auto-generated method stub
		Random ram = new Random();
		User user = this.resgisterUsers.get(userName);

		if (user.getQuetionAnswer().isEmpty())
			return null;

		Object[] listKeys = user.getQuetionAnswer().keySet().toArray();
		int pos = ram.nextInt(listKeys.length);
		return (String) listKeys[pos];

	}

	public boolean isValidAnswer(String userName, String q, String a) {

		User user = this.resgisterUsers.get(userName);
		if (user == null)
			return false;
		if (user.getQuetionAnswer().get(q) == null
				|| !user.getQuetionAnswer().get(q).equalsIgnoreCase(a))
			return false;
		
		return true;
	}

}
