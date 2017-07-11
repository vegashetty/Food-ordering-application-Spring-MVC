package com.foodapp.spring.dao;


import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodapp.spring.exception.AdException;

import com.foodapp.spring.pojo.Person;
import com.foodapp.spring.pojo.Admin;
import com.foodapp.spring.pojo.Chef;

public class AdminDAO extends DAO {

    public AdminDAO() {
    }

    public Admin get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Admin where username = :username");
            q.setString("username", username);
            Admin admin = (Admin) q.uniqueResult();
            commit();
            return admin;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

    public Admin create(String username, String password,String email)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
       
            Admin admin=new Admin(email);
            
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setRole("admin");
        admin.setEmail(email);
           
            
     
       
            getSession().save(admin);
            
            commit();
            return admin;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

 
}
