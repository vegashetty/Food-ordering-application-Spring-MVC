package com.foodapp.spring.dao;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodapp.spring.exception.AdException;

import com.foodapp.spring.pojo.Person;
import com.foodapp.spring.pojo.UserAccount;

import com.foodapp.spring.pojo.Customer;

public class CustomerDAO extends DAO {

    public CustomerDAO() {
    }

    public Customer get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Customer where username = :username");
            q.setString("username", username);
          
            Customer customer = (Customer) q.uniqueResult();
           
            commit();
          
            return customer;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Customer");
            List list = q.list();
            
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the cuisines", e);
        }
    }

    public Customer create(String username, String password, String firstName, String lastName,String email,int number, String address)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
       
            Customer customer=new Customer(address, email, number);
            
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setAddress(address);
            customer.setNumber(number);
            customer.setEmail(email);
            customer.setRole("customer");
            customer.setPassword(password);
            customer.setUsername(username);
     
       
            getSession().save(customer);
            
            commit();
            return customer;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }    
//    public UserAccount get(String username,String password) throws AdException {
//        try {
//            begin();
//            //insert code here
//            Query q = getSession().createQuery("from Category where title= :title");
//            q.setString("title", title);
//            Category category= (Category)q.uniqueResult();
//            commit();
//            return category;
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not obtain the named category " + title + " " + e.getMessage());
//        }
//    
//public UserAccount verifyUser(String uname, String pwd) throws AdException {
//        try {
//          getSession();
//          begin();
//          Query q = getSession().
//            String query = "select * from customer where username= ? and password=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, uname);
//            ps.setString(2, pwd);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                Customer c = new Customer();
//                c.setName(rs.getString("name"));
//                c.setCity(rs.getString("city"));
//                c.setCustomerID(rs.getInt("customerId"));
//                c.setPhone(rs.getString("phone"));
//                c.setUsername(rs.getString("username"));
//                c.setPassword(rs.getString("password"));
//                return c;
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            close(conn);
//            rs.close();
//            ps.close();
//        }
//        return null;
//    }
    public void delete(Customer customer)
            throws AdException {
        try {
            begin();
            getSession().delete(customer);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + customer.getFirstName(), e);
        }
    }
}
