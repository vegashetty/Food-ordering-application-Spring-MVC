package com.foodapp.spring.controller;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.List;
import java.util.Iterator;

import com.foodapp.spring.dao.CuisineDAO;
import com.foodapp.spring.dao.RecipeDAO;
import com.foodapp.spring.pojo.Cuisine;
import com.foodapp.spring.pojo.Recipe;

import com.foodapp.spring.dao.CuisineDAO;
import com.foodapp.spring.exception.AdException;
import com.foodapp.spring.pojo.Cuisine;
import com.foodapp.spring.pojo.Recipe;
import java.io.PrintWriter;
import java.util.ArrayList;

@Controller

public class CustomerViewController {

	@RequestMapping(value="/viewrecipe.htm", method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		  CuisineDAO cuisines = null;
		    
	        List cuisineList = null;
	        List recipeList = new ArrayList();

	        try {
	            cuisines = new CuisineDAO();
	            cuisineList = cuisines.list();

	            Iterator cuisineIterator = cuisineList.iterator();

	            while (cuisineIterator.hasNext())
	            {
	                Cuisine cuisine = (Cuisine) cuisineIterator.next();

	                Iterator recIterator = cuisine.getRecipes().iterator();

	                while (recIterator.hasNext())
	                {
	                    Recipe recipe = (Recipe) recIterator.next();
	                   if( recipe.isApprovedStatus() == true)
	                   {
	                    recipeList.add(recipe);
	                  
	                    request.setAttribute("recipeList",recipeList);
	                   }
	                }
	            }
	            //DAO.close();
	        } catch (AdException e) {
	            System.out.println(e.getMessage());
	        }
	        
	    
        ModelAndView mv = new ModelAndView("customerView", "dish", recipeList);
        return mv;
    }
	@RequestMapping(value="/searchrecipe.htm" ,method=RequestMethod.GET)
    protected ModelAndView returnView(@ModelAttribute("recipe")Recipe recipe, BindingResult result) throws Exception {
		
		
			  CuisineDAO cuisines = null;
			    
		       // List cuisineList = null;
		        List cuisineList = new ArrayList();

		        
		            cuisines = new CuisineDAO();
		            cuisineList = cuisines.list();

		ModelAndView mv = new ModelAndView("search","cuisines",cuisineList);
    
      
	    return mv;

	}
	
	
	@RequestMapping(value="/search.htm" ,method=RequestMethod.GET)
    protected String doSubmitAction(@ModelAttribute("recipe")Recipe recipe, BindingResult result,HttpServletRequest request, HttpServletResponse response) throws Exception{

		try{

    	CuisineDAO cuisineDao = new CuisineDAO();
    	//String key = request.getParameter("key");
        String cuisineName = recipe.getCuisine_name();  
    
  
  
Cuisine cuisine = cuisineDao.get(cuisineName);
System.out.println(cuisine.getCuisine_name());
      
//JSONObject obj = new JSONObject();
//       obj.put("books", bookList);
//       PrintWriter out = hsr1.getWriter(); //response
//       out.println(obj);

List<Recipe> recipeList = new ArrayList<Recipe>();
  Iterator recIterator = cuisine.getRecipes().iterator();

  while (recIterator.hasNext())
  {
      Recipe recipes = (Recipe) recIterator.next();
      if( recipes.isApprovedStatus() == true)
      {
      
      recipeList.add(recipes);
//    JSONObject obj = new JSONObject();
//    obj.put("recipeList", recipeList);
//  
//   PrintWriter out = response.getWriter(); //response
//   out.println(obj);
     request.setAttribute("recipeList",recipeList);
     
      }
}

        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        return "searchResults";
    }
	
//	@RequestMapping(value = "/addtocart.htm", method = RequestMethod.GET)
//	 protected ModelAndView doSubmitAction(HttpServletRequest request, HttpServletResponse response,@RequestParam("id")int id) throws Exception {
//		HttpSession session = request.getSession();
//		ArrayList<Recipe> cart;
//
//        if (session.getAttribute("cart") != null) {
//            cart = (ArrayList<Recipe>) session.getAttribute("cart");
//        } else {
//            cart = new ArrayList<Recipe>();
//        }
//
//       // int id = Integer.parseInt(request.getParameter("id"));
//        RecipeDAO recipeDao = new RecipeDAO();
//        Recipe recipe = recipeDao.get(id);
//        if (!cart.contains(recipe)) {
//            cart.add(recipe);
//        }
//        float total = 0;
//        for (Recipe p : cart) {
//            total = total + p.getPrice();
//        }
//        session.setAttribute("cart", cart);
//		ModelAndView mv = new ModelAndView("viewCart", "dish", cart);
//	    return mv;
//	}
	}