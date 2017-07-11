package com.foodapp.spring.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodapp.spring.exception.AdException;

import com.foodapp.spring.pojo.UserAccount;
import com.foodapp.spring.pojo.Admin;


public class LoginDAO extends DAO {

    public LoginDAO() {
    }

    public UserAccount get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from UserAccount where username = :username");
            q.setString("username", username);
            UserAccount ua = (UserAccount) q.uniqueResult();
            commit();
            return ua;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

//    public UserAccount get(String username)
//            throws AdException {
//        try {
//            begin();
//            Query q = getSession().createQuery("from UserAccount where username = :username");
//            q.setString("username", username);
//            UserAccount ua = (UserAccount) q.uniqueResult();
//            commit();
//            return ua;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not get user " + username, e);
//        }
//    }
    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from UserAccount  where username =?");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the users", e);
        }
    }


 
}
