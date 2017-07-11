package com.foodapp.spring.pojo;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

//import com.google.gson.annotations.Expose;

@Entity
@Table(name="cuisinetable")
public class Cuisine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cuisineid", unique=true, nullable=false)
    private long id;
	
	@Column(name="cuisine_name")
    private String cuisine_name;
	
    @OneToMany(fetch= FetchType.LAZY , mappedBy="cuisine")
	private Set<Recipe> recipes = new HashSet<Recipe>();

    public Cuisine(String name) {
        this.cuisine_name = name;
        this.recipes = new HashSet<Recipe>();
    }

    Cuisine() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getCuisine_name() {
		return cuisine_name;
	}

	public void setCuisine_name(String cuisine_name) {
		this.cuisine_name = cuisine_name;
	}
	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	  public void addRecipe(Recipe recipe) {
	       getRecipes().add(recipe);
	    }
}