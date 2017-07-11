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
@RequestMapping("/addadmin.htm")
public class AddAdminController {

	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("admin") Admin admin)  throws Exception
	
{

	
		try {
			System.out.print("test");
		
			AdminDAO adminDao = new AdminDAO();
		
			System.out.print("test1");
			
			
adminDao.create(admin.getUsername(),admin.getPassword(),admin.getEmail());
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedAdmin";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("admin") Admin admin) { 
		   

		return "registerAdmin";
	}
}
