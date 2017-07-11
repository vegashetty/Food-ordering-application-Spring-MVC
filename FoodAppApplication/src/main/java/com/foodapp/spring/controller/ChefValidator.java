package com.foodapp.spring.controller;

	import com.foodapp.spring.dao.ChefDAO;
import com.foodapp.spring.dao.CustomerDAO;
import com.foodapp.spring.exception.AdException;
import com.foodapp.spring.pojo.Chef;
import com.foodapp.spring.pojo.Customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
	import org.springframework.validation.Validator;
	import org.springframework.validation.ValidationUtils;

	public class ChefValidator implements Validator {
		static final String emailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	    public boolean supports(Class aClass)
	    {
	        return aClass.equals(Chef.class);
	    }

	    public void validate(Object obj, Errors errors)
	    {
	    	final int MINIMUM_PASSWORD_LENGTH = 6;
	    	Pattern pattern = Pattern.compile(emailPattern);
	        Matcher matcher;
	        Chef chef = (Chef) obj;
	        ChefDAO c = new ChefDAO();
	        String email;
	        email = chef.getEmail();
	        matcher = pattern.matcher(email);
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.firstName", "First Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.lastName", "Last Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.username", "User Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
	        
	        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.emailId", "Email Required");
	        if (chef.getPassword() != null
		              && chef.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) {
		           errors.rejectValue("password", "field.min.length",
		                 new Object[]{Integer.valueOf(MINIMUM_PASSWORD_LENGTH)},
		                 "The password must be at least [" + MINIMUM_PASSWORD_LENGTH + "] characters in length.");
		        
		           String username= chef.getUsername();
		           try {
					
					System.out.println("hello");
					 if(c.get(username) != null)
					 {
						 errors.rejectValue("username","error.invalid.username","Username exists"); 
					 }
				} catch (AdException e) {
					// TODO Auto-generated catch block
					System.out.println("error");
					e.printStackTrace();
				}
		           
		       
		          
		           if(!matcher.matches()) {
		               errors.rejectValue("email","error.invalid.email","Incorrect email format");
		          }
		        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
	    }
	}
	}
