package com.foodapp.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodapp.spring.dao.OrderDAO;
import com.foodapp.spring.dao.RecipeDAO;
import com.foodapp.spring.pojo.Recipe;
@Controller
@RequestMapping("/addtocart.htm")
public class AddCartController {
	@RequestMapping(method = RequestMethod.GET)
	 protected ModelAndView doSubmitAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ArrayList<Recipe> cart;
		//int quantity = (Integer)request.getParameter("q");

       if (session.getAttribute("cart") != null) {
           cart = (ArrayList<Recipe>) session.getAttribute("cart");
       } else {
           cart = new ArrayList<Recipe>();
       }

       int id = Integer.parseInt(request.getParameter("id"));
       RecipeDAO recipeDao = new RecipeDAO();
       Recipe recipe = recipeDao.get(id);
       if (!cart.contains(recipe)) {
           cart.add(recipe);
       }
       float total = 0;


       for (Recipe r : cart) {
           total = total +  r.getPrice();
       }
      
//       System.out.println(quantity);
//       session.setAttribute("quantity", quantity);

       session.setAttribute("cart", cart);
       session.setAttribute("total", total);
		ModelAndView mv = new ModelAndView("viewCart", "dish", cart);
	    return mv;
	}
//	@RequestMapping("/checkout.htm")
//		 protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
//			HttpSession session = request.getSession();
//			
////                int customerID = (int) session.getAttribute("customerID");
////                ArrayList<Recipe> cart = (ArrayList<Recipe>) session.getAttribute("cart");
////                OrderDAO od= new OrderDAO()
////               od.create(orderDate, customer);
////                od.create(recipeid, price, quantity, total);
//            session.removeAttribute("cart");
//               
//			ModelAndView mv = new ModelAndView("checkout");
//		    return mv;
//		}
	}

