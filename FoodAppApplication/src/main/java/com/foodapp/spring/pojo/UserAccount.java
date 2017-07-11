
package com.foodapp.spring.pojo;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="userAccounttable")
@PrimaryKeyJoinColumn(name="personID")
public class  UserAccount extends Person{
	@Column(name="role")
    private String role;
	@Column(name="username")
    private String username;
	@Column(name="password")
    private String password;


    public UserAccount(String role,String username, String password) {
    	this.role=role;
        this.username = username;
        this.password = password;
   
    }

    UserAccount() {
    }

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
