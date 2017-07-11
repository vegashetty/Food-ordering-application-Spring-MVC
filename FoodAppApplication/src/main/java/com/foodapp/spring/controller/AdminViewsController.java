
package com.foodapp.spring.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


import com.foodapp.spring.dao.CuisineDAO;
import com.foodapp.spring.exception.AdException;
import com.foodapp.spring.pojo.Cuisine;
import com.foodapp.spring.pojo.Recipe;

import java.util.List;
import java.util.Locale;
import java.util.Iterator;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class AdminViewsController{

	@RequestMapping(value = "sampleAjax", method = RequestMethod.POST)
	public @ResponseBody ArrayList<Recipe> sampleAjax(HttpServletRequest req) throws AdException {
        CuisineDAO cuisines = null;
        //String value = request.getParameter("action");
        List cuisineList = null;
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

    

       
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
                   if( recipe.isApprovedStatus() == false)
                   {
                    recipeList.add(recipe);
                    //request.setAttribute("recipeList",recipeList);
               	 //return recipeList;
                   }
                   
                }
                
            }
           
            //DAO.close();
      
//        if (value.equalsIgnoreCase("add")){
//            
//            recipe.setCustomerID(hsr.getParameter("CustomerID"));
//        
//            
//            salesDAO.updateSalesOrder(salesOrder);
//         
//            JSONObject object = new JSONObject();
//            object.put("message", "Inserted Id:"+salesOrder.getCustomerID());
//            PrintWriter out = hsr1.getWriter();
//            out.print(object);
		
           
          	 return recipeList;

   

    }
}


