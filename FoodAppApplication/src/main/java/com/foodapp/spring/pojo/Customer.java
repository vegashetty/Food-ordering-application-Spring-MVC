package com.foodapp.spring.pojo;



	import javax.persistence.Column;
	import javax.persistence.Entity;

	import javax.persistence.PrimaryKeyJoinColumn;
	import javax.persistence.Table;

	@Entity
	@Table(name="customertable")
	@PrimaryKeyJoinColumn(name="personID")
	public class Customer extends UserAccount{
		@Column(name="address")
	    private String address;
		@Column(name="number")
	    private int number;
		@Column(name="email")
	    private String email;
	

	    public Customer(String address, String email,int number) {
	        this.address= address;
	        this.number = number;
	        this.email = email;
	   
	    }

	    public Customer() {
	    }

	  

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	  


	}