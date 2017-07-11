package com.foodapp.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodapp.spring.exception.AdException;
import com.foodapp.spring.pojo.Recipe;
import com.foodapp.spring.pojo.Chef;
import com.foodapp.spring.pojo.Cuisine;
import com.foodapp.spring.pojo.Customer;

public class RecipeDAO extends DAO {

    public Recipe create(String recipeName, String description,float price,float distanceDelivery,boolean approvedStatus, Chef chef,Cuisine cuisine,String cuisine_name,String photoName)
            throws AdException {
        try {
            begin();
            Recipe recipe = new Recipe(recipeName, description,price,distanceDelivery,approvedStatus,chef, cuisine,cuisine_name,photoName);
            recipe.setRecipeName(recipeName);
            recipe.setDescription(description);
            recipe.setPrice(price);
            recipe.setChef(chef);
            recipe.setDistanceDelivery(distanceDelivery);
            recipe.setApprovedStatus(false);
            recipe.setCuisine_name(cuisine_name);
            //recipe.setCuisineid(cuisine_id);
            getSession().save(recipe);
            commit();
            return recipe;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdException("Exception while creating recipe: " + e.getMessage());
        }
    }
    public void update(long recipeid,boolean approvedStatus)
            throws AdException {
    	 try {
             begin();
        
             String hql = "update Recipe set approvedStatus = :newapprovedStatus where recipeid=:recipeid";
        Query query = getSession().createQuery(hql);
        query.setParameter("newapprovedStatus", approvedStatus);
        query.setParameter("recipeid", recipeid);

        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
       commit();
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdException("Exception while creating recipe: " + e.getMessage());
        }
    }
    public void updateRecipe(long recipeid,String description,float price)
            throws AdException {
    	 try {
             begin();
        
             String hql = "update Recipe set description = :description,price = :price where recipeid=:recipeid";
        Query query = getSession().createQuery(hql);
        query.setParameter("description", description);
        query.setParameter("price", price);
        query.setParameter("recipeid", recipeid);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        commit();

        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdException("Exception while creating recipe: " + e.getMessage());
        }
    }
    public Recipe get(long id)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Recipe where recipeId = :recipeId");
            q.setLong("recipeId", id);
          
            Recipe recipe = (Recipe) q.uniqueResult();
           
            commit();
          
            return recipe;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + id, e);
        }
    }
    public List<Recipe> list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Recipe");
           List<Recipe> list = new ArrayList<Recipe>();
            list = q.list();
          
           
            
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the categories", e);
        }
    }
    public List getChef(long chef)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Recipe where chef = :chef");
            q.setLong("chef", chef);
          
           // Recipe recipe = (Recipe) q.uniqueResult();
            List list = q.list();
            
            commit();
          
            return list;
          
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + chef, e);
        }
    }
    public void delete(Recipe recipe)
            throws AdException {
        try {
            begin();
            getSession().delete(recipe);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete recipe", e);
        }
    }
}