package com.foodapp.spring.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="recipetable")
public class Recipe {

	@Id
	@GeneratedValue

	@Column(name="recipeid", unique=true, nullable=false)

    private long id;
	@Column(name="recipeName")
    private String recipeName;
	@Column(name="description")
    private String description;
	@Column(name="price")
    private float price;
	@Column(name="distanceDelivery")
    private float distanceDelivery;
	
	@Column(name="approvedStatus")
    private boolean approvedStatus;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cuisineid")
	Cuisine cuisine;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="chef")
    private Chef chef;
	@Transient//Property won't be saved to db.
    private String postedBy;
	@Transient
	private MultipartFile photo;
	@Column(name="photoName")
    private String photoName;
    @Transient
    private String cuisine_name;
//	@JoinColumn(name="cuisineid")
//    private long cuisineid;

    public Recipe(String recipeName, String description,float price,float distanceDelivery,boolean approvedStatus, Chef chef,Cuisine cuisine,String cuisine_name,String photoName) {
        this.recipeName = recipeName;
        this.description = description;
        this.chef = chef;
        this.cuisine = cuisine;
        this.approvedStatus = approvedStatus;
        this.distanceDelivery = distanceDelivery;
        this.cuisine_name=cuisine_name;
        this.photoName = photoName;
    }

    Recipe() {
    }

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public float getDistanceDelivery() {
		return distanceDelivery;
	}

	public void setDistanceDelivery(float distanceDelivery) {
		this.distanceDelivery = distanceDelivery;
	}

	public boolean isApprovedStatus() {
		return approvedStatus;
	}

	public void setApprovedStatus(boolean approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public String getCuisine_name() {
		return cuisine_name;
	}

	public void setCuisine_name(String cuisine_name) {
		this.cuisine_name = cuisine_name;
	}

//	public long getCuisineid() {
//		return cuisineid;
//	}
//
//	public void setCuisineid(long cuisineid) {
//		this.cuisineid = cuisineid;
//	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
//	  @Override
//	    public String toString() {
//	        return "Recipe{" + "recipeName=" + recipeName + ", description=" + description + "}";
//	    }
//	    


}