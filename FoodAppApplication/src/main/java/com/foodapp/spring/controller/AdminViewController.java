package com.foodapp.spring.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.foodapp.spring.dao.CuisineDAO;
import com.foodapp.spring.dao.RecipeDAO;
import com.foodapp.spring.exception.AdException;
import com.foodapp.spring.pojo.Cuisine;
import com.foodapp.spring.pojo.Recipe;


import net.sf.json.JSONException;

import java.util.List;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Controller


public class AdminViewController{

	
	@RequestMapping(value="/listrecipes.htm",method=RequestMethod.GET)
	
	
	
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CuisineDAO cuisines = null;
    
        List cuisineList = null;
        List<Recipe> recipeList = new ArrayList<Recipe>();
       // final Logger logger = Logger.getLogger(this.getClass());

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
                   if( recipe.isApprovedStatus() == false)
                   {
                    recipeList.add(recipe);
                    request.setAttribute("recipeList",recipeList);
                  System.out.println(recipeList);
                   }
                }
            }
            
            //DAO.close();
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
//        
//		RecipeDAO r = new RecipeDAO();
//		List<Recipe> recipeList = r.list();
//	request.setAttribute("recipes",recipeList);
//		ModelAndView mv = new ModelAndView("adminView");
//		return mv;
//        JSONObject obj = new JSONObject();
//      
//        obj.put("recipes",recipeList);
//    
//   
//        PrintWriter out = response.getWriter();
//        out.println(obj);
//   
//        return null;
        ModelAndView mv = new ModelAndView("adminView");
		return mv;
    }
	
	@RequestMapping(value="/approve.htm",method=RequestMethod.GET)
    protected ModelAndView approve(HttpServletRequest request, HttpServletResponse response) throws Exception {
	long id= Long.parseLong(request.getParameter("id"));
	
	RecipeDAO rd = new RecipeDAO();
	rd.update(id, true);
	
		  ModelAndView mv = new ModelAndView("approveRecipe");
			return mv;
	}
	@RequestMapping(value="/email.htm",method=RequestMethod.GET)
    protected ModelAndView mail(HttpServletRequest request, HttpServletResponse response) throws Exception {

		  ModelAndView mv = new ModelAndView("email");
			return mv;
	}

	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */




	
	
	String subject;
	String text;
	
	public static boolean sendMail(String from,String password,String message,String to[],HttpServletRequest request, HttpServletResponse response){
	 String host="smtp.gmail.com";
	 Properties props= System.getProperties();
	 props.put("mail.smtp.starttls.enable","true");
	 props.put("mail.smtp.host",host );
	  props.put("mail.smtp.user",from );
	   props.put("mail.smtp.password",password );
	    props.put("mail.smtp.port",587 );
	     props.put("mail.smtp.auth","true" );
	     Session session=Session.getDefaultInstance(props, null);
	     MimeMessage  mimeMessage=new  MimeMessage(session);
	     try{
	         mimeMessage.setFrom(new InternetAddress(from));
	     InternetAddress[] toAddress=new InternetAddress[to.length];
	     for(int i=0;i<to.length;i++)
	     {
	         toAddress[i]=new InternetAddress(to[i]);
	     }
	     for(int i=0;i<toAddress.length;i++)
	     {
	     mimeMessage.addRecipient(RecipientType.TO,toAddress[i]);
	     
	     }
	     String subject1 = request.getParameter("subject");
	     String message1 = request.getParameter("message");
	     String recipientAddress = request.getParameter("recipient");
	     mimeMessage.setSubject(subject1);
	     mimeMessage.setText(message1);
	     Transport transport=session.getTransport("smtp");
	     transport.connect(host,from,password);
	     transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
	     transport.close();
	     return false;
	     }
	     catch(MessagingException me)
	     {
	     me.printStackTrace();
	     }
	     
	     
	     
	  return  false;
	 
	}

	

//	 
//	 
//	     
	    @RequestMapping(value="sendEmail.htm",method = RequestMethod.POST)
	    public String doSendEmail(HttpServletRequest request,HttpServletResponse response) {
	        // takes input from e-mail form
	        String recipientAddress[] = new String[]{ request.getParameter("recipient")};
	        String subject = request.getParameter("subject");
	        String message = request.getParameter("message");
	         
	  
	        sendMail("vegashetty@gmail.com","@Flitwick12", message,recipientAddress, request, response);
	      
	        // forwards to the view named "Result"
	        return "Result";
	    }
	
}
