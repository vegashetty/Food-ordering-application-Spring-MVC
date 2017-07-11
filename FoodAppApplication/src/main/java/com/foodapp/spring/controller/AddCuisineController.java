package com.foodapp.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodapp.spring.dao.CuisineDAO;
import com.foodapp.spring.exception.AdException;
import com.foodapp.spring.pojo.Cuisine;

@Controller
@RequestMapping("/addcuisine.htm")
public class AddCuisineController
{
	@InitBinder
	private void initBinder(WebDataBinder binder) {
	}
	
	@RequestMapping(method=RequestMethod.POST)
    protected String doSubmitAction(@RequestParam("cuisine_name")Cuisine cuisine) throws Exception
    {
		
        
        try
        {
            CuisineDAO cuisineDAO = new CuisineDAO();
            cuisineDAO.create(cuisine.getCuisine_name());
            //DAO.close();
        }
        catch (AdException e)
        {
            System.out.println(e.getMessage());
        }
        return "addedCuisine";
    }
    
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("cuisine")Cuisine cuisine, BindingResult result) { 
   
        return "addCuisine"; 
    } 
}