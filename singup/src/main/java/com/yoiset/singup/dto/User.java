package com.yoiset.singup.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String userName;
	private Date dob;
	private HashMap<String, String> quetionAnswer;

	public User() {
		quetionAnswer = new HashMap<String, String>();
	}
	public User(String userName, Date dob) {
		this.userName=userName;
		this.dob = dob;
		quetionAnswer = new HashMap<String, String>();
	}
	
	public User(String userName) {
		this.userName=userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	public HashMap<String, String> getQuetionAnswer() {
		return quetionAnswer;
	}
	public void setQuetionAnswer(HashMap<String, String> quetionAnswer) {
		this.quetionAnswer = quetionAnswer;
	}

}
