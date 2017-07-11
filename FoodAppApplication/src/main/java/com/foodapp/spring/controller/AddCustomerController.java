package com.foodapp.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodapp.spring.pojo.Customer;
import com.foodapp.spring.pojo.UserAccount;
import com.foodapp.spring.controller.CustomerValidator;
import com.foodapp.spring.dao.DAO;
import com.foodapp.spring.dao.LoginDAO;
//import com.foodapp.spring.dao.customer;
import com.foodapp.spring.dao.CustomerDAO;
import com.foodapp.spring.exception.AdException;

@Controller
@RequestMapping("/addcustomer.htm")
public class AddCustomerController {
	@Autowired

	@Qualifier("customerValidator")
	CustomerValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("customer") Customer customer, BindingResult result,@RequestParam("username")String userName)
			throws Exception

	{
		validator.validate(customer, result);
		if (result.hasErrors()) {
			return "login";
		}
	
		try {

			System.out.print("test");
			CustomerDAO customerDao = new CustomerDAO();
			
			// if(customerDao.get("vega").equals(customer.getUsername())){
			// System.out.print("test1");
			// }
			// if (!result.hasErrors()) {
			// System.out.println("<b>"+customer.getUsername() +"</b> is
			// avaliable</font>");
//			customer = customerDao.get(userName);
//			if(customer.equals(customer.getUsername()))
//			{
//				return "success";
//			}
			
	
						
						customerDao.create(customer.getUsername(), customer.getPassword(), customer.getFirstName(),
								customer.getLastName(), customer.getAddress(), customer.getNumber(), customer.getEmail());
						System.out.print(customer);
				      
				   
				

		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "newCustomer";
	}
//	 @RequestMapping(value="/isUserNameUnique.htm",method = RequestMethod.POST)
//	 protected String isUnique(@RequestParam("userName") String username){
//	 Customer c = new Customer();
//	 CustomerDAO customerDao = new CustomerDAO();
//	 c = customerDao.get(username);
//	 if(c != null){
//	 return "success";
//	 }
//	 }

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("customer") Customer customer, BindingResult result) {

		return "login";
	}
}
