package com.foodapp.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodapp.spring.dao.ChefDAO;
import com.foodapp.spring.dao.CuisineDAO;
import com.foodapp.spring.dao.RecipeDAO;
import com.foodapp.spring.exception.AdException;
import com.foodapp.spring.pojo.Chef;
import com.foodapp.spring.pojo.Cuisine;
import com.foodapp.spring.pojo.Recipe;

@Controller
public class UpdateDeleteController {
	@RequestMapping(value="/delete.htm" ,method=RequestMethod.GET)
    protected ModelAndView doSubmitAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String action = request.getParameter("action");
		RecipeDAO rd = new RecipeDAO();

		ModelAndView mv = new ModelAndView();
      if(action.equals("delete"))
      {
			long rid =  Long.parseLong(request.getParameter("id"));
			
			Recipe recipe = rd.get(rid);
			 request.setAttribute("rname",recipe.getRecipeName());
		
		       rd.delete(recipe);
               mv.setViewName("deleted");

      }
      if(action.equals("update"))
      {
			long rid =  Long.parseLong(request.getParameter("id"));
			Recipe recipe = rd.get(rid);
		String s = request.getParameter("desc");
		System.out.println(s);
		float price = Float.parseFloat(request.getParameter("price"));
		rd.updateRecipe(rid,s,price);
	
               mv.setViewName("updated");

      }
      
	    return mv;

	}

	
	
	
}
