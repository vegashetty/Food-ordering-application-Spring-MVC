package com.foodapp.spring.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodapp.spring.exception.AdException;

import com.foodapp.spring.pojo.Customer;
import com.foodapp.spring.pojo.Order;
import com.foodapp.spring.pojo.OrderDetails;
import com.foodapp.spring.pojo.Recipe;


public class OrderDAO extends DAO{
	
	public Order create(Order o)
            throws AdException {
        try {
            begin();

//      
            getSession().save(o);
            commit();
            return o;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdException("Exception while creating recipe: " + e.getMessage());
        }
    }
    public  List list(long customerId)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Order where customerId = :customerId");
            q.setLong("customerId", customerId);
          
            List list = q.list();
           
            commit();
          
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + customerId, e);
        }
    }
    public  List detailslist(long orderid)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from OrderDetails where orderid = :orderid");
            q.setLong("orderid", orderid);
          
            List list = q.list();
           
            commit();
          
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + orderid, e);
        }
    }
	public OrderDetails create(OrderDetails orderDetails)
            throws AdException {
        try {
            begin();

      
            getSession().save(orderDetails);
            commit();
            return orderDetails;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdException("Exception while creating recipe: " + e.getMessage());
        }
    }

}
