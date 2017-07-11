package com.foodapp.spring.pojo;



	import javax.persistence.Column;
	import javax.persistence.Entity;

	import javax.persistence.PrimaryKeyJoinColumn;
	import javax.persistence.Table;

	@Entity
	@Table(name="cheftable")
	@PrimaryKeyJoinColumn(name="personID")
	public class Chef extends UserAccount{
		@Column(name="address")
	    private String address;
		@Column(name="number")
	    private int number;
		@Column(name="email")
	    private String email;
		@Column(name="speciality")
	    private String speciality;

	    public Chef(String address, String email,int number,String speciality) {
	        this.address= address;
	        this.speciality  = speciality;
	        this.number = number;
	        this.email = email;
	   
	    }

	    Chef() {
	    }

	  

		public String getSpeciality() {
			return speciality;
		}

		public void setSpeciality(String speciality) {
			this.speciality = speciality;
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