package com.foodapp.spring.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodapp.spring.exception.AdException;

import com.foodapp.spring.pojo.Person;
import com.foodapp.spring.pojo.Chef;

public class ChefDAO extends DAO {

    public ChefDAO() {
    }

    public Chef get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Chef where username = :username");
            q.setString("username", username);
            Chef chef = (Chef) q.uniqueResult();
            commit();
            return chef;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

    public Chef create(String username, String password, String firstName, String lastName,String email,int number, String address,String speciality)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
       
            Chef chef=new Chef(address, email, number,speciality);
            chef.setUsername(username);
            chef.setPassword(password);
            chef.setFirstName(firstName);
            chef.setLastName(lastName);
            chef.setAddress(address);
            chef.setNumber(number);
            chef.setEmail(email);
            chef.setSpeciality(speciality);
            chef.setRole("chef");
            
            
     
       
            getSession().save(chef);
            
            commit();
            return chef;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Chef");
            List list = q.list();
            
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the cuisines", e);
        }
    }
    
    
    public void delete(Chef chef)
            throws AdException {
        try {
            begin();
            getSession().delete(chef);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + chef.getFirstName(), e);
        }
    }
}
