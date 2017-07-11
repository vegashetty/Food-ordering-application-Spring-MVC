package com.foodapp.spring.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodapp.spring.exception.AdException;
import com.foodapp.spring.pojo.Cuisine;

public class CuisineDAO extends DAO {

    public Cuisine get(String name) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from Cuisine where cuisine_name= :cuisine_name");
            q.setString("cuisine_name",name);
            Cuisine cuisine=(Cuisine)q.uniqueResult();
            commit();
            return cuisine;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named cuisine " + name + " " + e.getMessage());
        }
    }

    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Cuisine");
            List list = q.list();
            
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the cuisines", e);
        }
    }

    public Cuisine create(String name) throws AdException {
        try {
            begin();
            Cuisine c = new Cuisine(name);
            getSession().save(c);
            commit();
            return null;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create the category", e);
            throw new AdException("Exception while creating cuisine: " + e.getMessage());
        }
    }

    public void save(Cuisine cuisine) throws AdException {
        try {
            begin();
            getSession().update(cuisine);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not save the cuisine", e);
        }
    }

    public void delete(Cuisine cuisine) throws AdException {
        try {
            begin();
            getSession().delete(cuisine);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete the cuisine", e);
        }
    }
}