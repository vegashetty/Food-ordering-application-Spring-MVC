package com.foodapp.spring.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.ModelAndView;

import com.foodapp.spring.dao.ChefDAO;
import com.foodapp.spring.dao.CuisineDAO;
import com.foodapp.spring.dao.DAO;
import com.foodapp.spring.dao.LoginDAO;
import com.foodapp.spring.dao.RecipeDAO;
import com.foodapp.spring.exception.AdException;
import com.foodapp.spring.pojo.Chef;
import com.foodapp.spring.pojo.Cuisine;
import com.foodapp.spring.pojo.OrderDetails;
import com.foodapp.spring.pojo.Recipe;




@Controller
//@RequestMapping("/addrecipe.htm")

public class photoController {
	@Autowired 
	
	@Qualifier("cuisineDao")
	CuisineDAO cuisineDao;
	

	@InitBinder
	private void initBinder(WebDataBinder binder)
{
		//binder.setValidator(rvalidator);
		}
	
	@RequestMapping(value="/addrecipe.htm" ,method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("recipe")Recipe recipe, BindingResult result,HttpServletRequest request, HttpServletResponse response) throws Exception{

		
	
       String chefName= recipe.getPostedBy();
        String cuisineName = recipe.getCuisine_name();  
        String recipeName = recipe.getRecipeName();    
        String description = recipe.getDescription();
        float distanceDelivery = recipe.getDistanceDelivery();
float price = recipe.getPrice();


File file;
String check = File.separator;
String path = null;
ServletContext context = request.getSession().getServletContext();

 if(check.equalsIgnoreCase("/")) {
path = context.getRealPath("").replace("build/","");
path += "/"; 

}
 
 
if(recipe.getPhoto() != null)
{

String fileNameWithExt = System.currentTimeMillis() + recipe.getPhoto().getOriginalFilename();

file= new File(path+fileNameWithExt);

String context1 = context.getContextPath();
recipe.getPhoto().transferTo(file);

recipe.setPhotoName(context1+"/"+ fileNameWithExt);


}

String photoName = recipe.getPhotoName();
        try {
        

      	ChefDAO chefs = new ChefDAO();
        	Chef c = chefs.get(chefName);
//Chef c= recipe.getChef();
          RecipeDAO recipes = new RecipeDAO();
  
Cuisine cuisine = cuisineDao.get(cuisineName);


            Recipe rec = recipes.create(recipeName, description,price,distanceDelivery,recipe.isApprovedStatus(), c,cuisine,cuisine.getCuisine_name(),photoName);
cuisine.addRecipe(rec);
cuisineDao.save(cuisine);           

            
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        return "addedRecipe";
    }
    
	@RequestMapping(value="/addrecipe.htm" ,method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("recipe")Recipe recipe, BindingResult result) { 
		//Recipe recipe = new Recipe();
		//model.addObject("recipe",recipe);
        return "addCuisine"; 
    } 
	@RequestMapping(value="/viewChefRecipes.htm" ,method=RequestMethod.GET)
    protected ModelAndView doSubmitAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String chef = (String) session.getAttribute("chefName");
	ChefDAO chefdao = new ChefDAO();
	Chef c = chefdao.get(chef);
		long id = c.getPersonID();

		
	RecipeDAO rd = new RecipeDAO();
	//Recipe r = rd.getChef(id);
	 List recipeList = null;
	 ArrayList<Recipe> rList = new ArrayList();

	 recipeList = rd.getChef(id);



     Iterator listIterator = recipeList.iterator();



     while (listIterator.hasNext())

     {

        Recipe r = (Recipe) listIterator.next();
        rList.add(r);
       // r.getRecipeName();
        request.setAttribute("recipeList",rList);
//        if(action.equals("delete"))
//        {
//			long rid =  Long.parseLong(request.getParameter("id"));
//			Recipe recipe = rd.get(id);
//		       rd.delete(recipe);
//        }
//        
     }
    
		ModelAndView mv = new ModelAndView("viewChefRecipes");
	    return mv;

   
    }

}
