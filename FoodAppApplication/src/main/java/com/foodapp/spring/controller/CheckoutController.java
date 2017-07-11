package com.foodapp.spring.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodapp.spring.dao.OrderDAO;
import com.foodapp.spring.dao.RecipeDAO;
import com.foodapp.spring.exception.AdException;
import com.foodapp.spring.pojo.Customer;
import com.foodapp.spring.pojo.Order;
import com.foodapp.spring.pojo.OrderDetails;
import com.foodapp.spring.pojo.Recipe;
import com.foodapp.spring.pojo.UserAccount;

@Controller
//@RequestMapping("/checkout.htm")
public class CheckoutController {
	@RequestMapping(value="/checkout.htm",method = RequestMethod.GET)

	 protected ModelAndView doSubmitAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
			HttpSession session = request.getSession();
			               long customerID = (Long) session.getAttribute("customerId");
			               float total = (Float) session.getAttribute("total");
               ArrayList<Recipe> cart = (ArrayList<Recipe>) session.getAttribute("cart");
OrderDAO od = new OrderDAO();


Order o = new Order();
DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date date = new Date();
String oDate = dateFormat.format(date);
o.setOrderDate(oDate);
o.setCustomerId(customerID);
od.create(o);
session.setAttribute("orderid",o.getOrderid());

		
			
			for(Recipe r : cart)
			{
				OrderDetails odetails = new OrderDetails();
		
			odetails.setPrice(r.getPrice());
				odetails.setRecipeid(r.getId());
				odetails.setTotal(total);
				long oid = o.getOrderid();
				long orderid = (Long) session.getAttribute("orderid");
				
				odetails.setOrderid(orderid);
				
		od.create(odetails);
			}
				 session.removeAttribute("cart");
              
			ModelAndView mv = new ModelAndView("checkout");
		    return mv;
		}
	
	@RequestMapping(value="/deleteItem.htm",method = RequestMethod.GET)
	 public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			long id =  Long.parseLong(request.getParameter("id"));
			
			
			
//			System.out.println(id);
//
			HttpSession session = request.getSession();

		       RecipeDAO recipeDao = new RecipeDAO();
		       Recipe recipe = recipeDao.get(id);
		       ArrayList<Recipe> cart = (ArrayList<Recipe>) session.getAttribute("cart");
		       cart.remove(0);
		       //float total = (Float)session.getAttribute("total");
		       
		       ModelAndView mv = new ModelAndView("viewCart");
			    return mv;
	}
	@RequestMapping(value="/logout.htm",method = RequestMethod.GET)
	 public void logout(@ModelAttribute("login")UserAccount user,HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);

		      // ModelAndView mv = new ModelAndView();
			  //  return mv;
	}
	@RequestMapping(value="/viewCartItems.htm",method = RequestMethod.GET)
	 public void viewCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/viewCart.jsp");
		view.forward(request, response);

		      // ModelAndView mv = new ModelAndView();
			  //  return mv;
	}

}
