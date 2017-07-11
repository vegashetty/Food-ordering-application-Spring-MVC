package com.foodapp.spring.controller;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foodapp.spring.pojo.Admin;
import com.foodapp.spring.pojo.Customer;
import com.foodapp.spring.pojo.UserAccount;
import com.foodapp.spring.controller.CustomerValidator;
import com.foodapp.spring.dao.DAO;
import com.foodapp.spring.dao.LoginDAO;
import com.foodapp.spring.dao.CustomerDAO;
import com.foodapp.spring.exception.AdException;

@Controller
@RequestMapping("/login.htm")
public class LoginController {



	
	@Autowired //Here the authenticate service is automatically injected into this controller
		@Qualifier("loginDao")
		LoginDAO loginDao;
	@RequestMapping(method = RequestMethod.POST)
	//@ModelAttribute("user")UserAccount user,
	  //protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
	public String doSubmitAction(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("login")UserAccount user,@RequestParam("username")String userName,@RequestParam("password")String password) {
try{
    HttpSession session = request.getSession();

		UserAccount ua = loginDao.get(userName);
	
		if( ua   != null) {


		if( (ua.getUsername()).equals(userName) && (ua.getPassword()).equals(password) && ua.getRole().equals("customer") ){
		
            session.setAttribute("customerId", ua.getPersonID());

			return "addedCustomer";
		
		}
		else if( (ua.getUsername()).equals(userName) && (ua.getPassword()).equals(password) && ua.getRole().equals("chef") ){

            session.setAttribute("chefName", userName);

			//return "addCuisine";
			return "chefView";


		}
		else if( (ua.getUsername()).equals(userName) && (ua.getPassword()).equals(password) && ua.getRole().equals("admin") ){
		
			 session.setAttribute("admin", userName);
			return "adminChoice";
			// return "index1";
			//return "approveRecipe";


		}
		}
		}
		catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
System.out.print("test");

return "error";
	
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("login")UserAccount userAcc) { 
		   

		return "loginView";
	}
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String privatePage() {
//		return "error";
//	}

//	@RequestMapping("/error.htm")
//
//	 public ModelAndView getAccessDenied(@RequestParam("username")String userName) {
//		 
//		 try{
//				System.out.print("test");
//		  Authentication auth = SecurityContextHolder.getContext()  
//		    .getAuthentication();  
//		 
//		  if (!(auth instanceof AnonymousAuthenticationToken)) {
//			  Customer c = customerDao.get(userName);
//			  c.getUsername();
//		  }  
//		 }
//		 catch (AdException e) {
//				System.out.println("Exception: " + e.getMessage());
//			}
//		  return new ModelAndView("error");
//		
//		 }  
}
