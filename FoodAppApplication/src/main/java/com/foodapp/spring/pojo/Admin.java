package com.foodapp.spring.pojo;



	import javax.persistence.Column;
	import javax.persistence.Entity;

	import javax.persistence.PrimaryKeyJoinColumn;
	import javax.persistence.Table;

	@Entity
	@Table(name="admintable")
	@PrimaryKeyJoinColumn(name="personID")
	public class Admin extends UserAccount{
		
		@Column(name="email")
	    private String email;
	

	    public Admin(String email) {
	    
	        this.email = email;
	   
	    }

	    Admin() {
	    }

	  

	

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	  



}
