package com.foodapp.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="orderDetailsTable")

public class OrderDetails{

	@Id
	@GeneratedValue

	@Column(name="orderDetailsId", unique=true, nullable=false)
	   private long orderDetailsId;
	
	@Column(name="recipeid")
    private long recipeid;
	
	@Column(name="price")
    private float price;
	
	@Column(name="total")
    private float total;
	
	@Column(name="orderid")
    private long orderid;
	
	
	 public OrderDetails(long recipeid,float price,long orderid) {
		    
		    this.recipeid = recipeid;
		    this.price = price;
		    this.orderid = orderid;
		   // this.quantity = quantity;
		    this.total = total;
		    
		    }

		   public OrderDetails() {
		    }

	public long getOrderid() {
				return orderid;
			}

			public void setOrderid(long orderid) {
				this.orderid = orderid;
			}

	public long getOrderDetailsId() {
				return orderDetailsId;
			}

			public void setOrderDetailsId(long orderDetailsId) {
				this.orderDetailsId = orderDetailsId;
			}

	public long getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(long recipeid) {
		this.recipeid = recipeid;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
