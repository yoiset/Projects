package com.yoiset.signup.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SupportController {

	public SupportController() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static HashMap<Integer, List<String>> generateQuetion(){
		
		HashMap<Integer, List<String>> result= new HashMap<Integer, List<String>>();
		
		List<String> quetions = new ArrayList<String>();
		quetions.add("What's your favorite color?");
		quetions.add("What's your natal town");
		quetions.add("What's your mother last name?");
		
		List<String> quetions2 = new ArrayList<String>();
		quetions2.add("What's your favorite car brand?");
		quetions2.add("What's your favorite food");
		quetions2.add("What's your mother birthday?");
		
		List<String> quetions3 = new ArrayList<String>();
		quetions3.add("What's your favorite song?");
		quetions3.add("What's your grand father nick name");
		quetions3.add("What's your father nick name?");
		
		result.put(1, quetions);
		result.put(2, quetions2);
		result.put(3, quetions3);
		
		return result;
		
	}


	public static boolean isInvalidQA(String q1, String q2, String q3,
			String r1, String r2, String r3) {
		
		if(q1 == null || q2==null || q3==null || r1==null || r2==null || r3==null ||
				q1.isEmpty() || q2.isEmpty() || q3.isEmpty() || r1.isEmpty() || 
				r2.isEmpty() || r3.isEmpty())
			return true;
		
		return false;
	}

}
