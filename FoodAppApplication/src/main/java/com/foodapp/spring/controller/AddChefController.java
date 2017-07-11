package com.foodapp.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodapp.spring.pojo.Admin;
import com.foodapp.spring.pojo.Chef;
import com.foodapp.spring.pojo.Customer;
import com.foodapp.spring.controller.CustomerValidator;
import com.foodapp.spring.dao.DAO;
import com.foodapp.spring.dao.AdminDAO;
import com.foodapp.spring.dao.ChefDAO;
import com.foodapp.spring.dao.CustomerDAO;
import com.foodapp.spring.exception.AdException;

@Controller
@RequestMapping("/addchef.htm")
public class AddChefController {
	@Autowired
	@Qualifier("chefValidator")
	ChefValidator cvalidator;
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(cvalidator);
		}
//	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("chef") Chef chef, BindingResult result)  throws Exception
	
{
	cvalidator.validate(chef, result);
	if (result.hasErrors()) {
		return "register";
	}
//	
		try {
			System.out.print("test");
			ChefDAO chefDao = new ChefDAO();
			
		
			System.out.print("test1");
			
			chefDao.create(chef.getUsername(), chef.getPassword(), chef.getFirstName(), chef.getLastName(),chef.getAddress(),chef.getNumber(),chef.getEmail(),chef.getSpeciality());
		
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "newChef";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("chef") Chef chef) { 
		   

		return "register";
	}
}
