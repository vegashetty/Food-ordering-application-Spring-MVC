package com.foodapp.spring.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordertable")
public class Order {
	@Id
	@GeneratedValue

	@Column(name="orderid", unique=true, nullable=false)

    private long orderid;
	@Column(name="orderDate")
    private String orderDate;
	
	@Column(name="customerId")
    private long customerId;

    public Order(String orderDate,long customerId) {
    
    this.orderDate = orderDate;
    this.customerId = customerId;
    
    }

   public Order() {
    }

	
	
	
	
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	

   
}
