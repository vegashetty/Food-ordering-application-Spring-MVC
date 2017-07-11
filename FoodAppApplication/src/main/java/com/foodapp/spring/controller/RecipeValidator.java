package com.foodapp.spring.controller;

	
import com.foodapp.spring.pojo.Recipe;



import org.springframework.validation.Errors;
	import org.springframework.validation.Validator;
	import org.springframework.validation.ValidationUtils;

	public class RecipeValidator implements Validator {
		
	    public boolean supports(Class aClass)
	    {
	        return aClass.equals(Recipe.class);
	    }

	    public void validate(Object obj, Errors errors)
	    {
	    
	        Recipe recipe = (Recipe) obj;
	
	     
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "recipeName", "error.invalid.recipeName", "First Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.description", "Last Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.price", "User Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "distanceDelivery", "error.invalid.distanceDelivery", "Password Required");
	        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.emailId", "Email Required");
	
		        
		          
		       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
	    
	}
	}

