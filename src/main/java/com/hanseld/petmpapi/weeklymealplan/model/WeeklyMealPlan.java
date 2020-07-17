package com.hanseld.petmpapi.weeklymealplan.model;


import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hanseld.petmpapi.food.model.Food;
import com.hanseld.petmpapi.pet.model.Pet;

import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "_weekly_meal_plans", 
	   indexes = { @Index(name = "ind_wmp_title", columnList = "wmp_title"),
			       @Index(name = "ind_wmp_meal_type", columnList = "wmp_meal_type") })
public class WeeklyMealPlan implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "wmp_id")
	private Long id;
	
	@Basic
	@Column(name = "wmp_title")
	private String title;
	
	@Basic
	@Column(name = "wmp_description")
	private String description;
	
	@Basic
	@Enumerated(EnumType.STRING)
	@Column(name = "wmp_meal_type")
	private EMealType mealType;
	
	@OneToMany(mappedBy = "id")
	private List<Pet> pets;
	
	@JoinColumn(name = "wmp_sunday_meal_id", foreignKey = @ForeignKey(name = "_wmp_sunday_meal_fk"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private Food sundayMeal;
	
	@JoinColumn(name = "wmp_monday_meal_id", foreignKey = @ForeignKey(name = "_wmp_monday_meal_fk"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private Food mondayMeal;
	
	@JoinColumn(name = "wmp_tuesday_meal_id", foreignKey = @ForeignKey(name = "_wmp_tuesday_meal_fk"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private Food tuesdayMeal;

	@JoinColumn(name = "wmp_wednesday_meal_id", foreignKey = @ForeignKey(name = "_wmp_wednesday_meal_fk"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private Food wednesdayMeal;
	
	@JoinColumn(name = "wmp_thursday_meal_id", foreignKey = @ForeignKey(name = "_wmp_thursday_meal_fk"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private Food thursdayMeal;
	
	@JoinColumn(name = "wmp_friday_meal_id", foreignKey = @ForeignKey(name = "_wmp_friday_meal_fk"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private Food fridayMeal;
	
	@JoinColumn(name = "wmp_saturday_meal_id", foreignKey = @ForeignKey(name = "_wmp_saturday_meal_fk"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private Food saturdayMeal;
	
	@Basic
	@Column(name = "wmp_created_on")
	private OffsetDateTime createdOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EMealType getMealType() {
		return mealType;
	}

	public void setMealType(EMealType mealType) {
		this.mealType = mealType;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Food getSundayMeal() {
		return sundayMeal;
	}

	public void setSundayMeal(Food sundayMeal) {
		this.sundayMeal = sundayMeal;
	}

	public Food getMondayMeal() {
		return mondayMeal;
	}

	public void setMondayMeal(Food mondayMeal) {
		this.mondayMeal = mondayMeal;
	}

	public Food getTuesdayMeal() {
		return tuesdayMeal;
	}

	public void setTuesdayMeal(Food tuesdayMeal) {
		this.tuesdayMeal = tuesdayMeal;
	}

	public Food getWednesdayMeal() {
		return wednesdayMeal;
	}

	public void setWednesdayMeal(Food wednesdayMeal) {
		this.wednesdayMeal = wednesdayMeal;
	}

	public Food getThursdayMeal() {
		return thursdayMeal;
	}

	public void setThursdayMeal(Food thursdayMeal) {
		this.thursdayMeal = thursdayMeal;
	}

	public Food getFridayMeal() {
		return fridayMeal;
	}

	public void setFridayMeal(Food fridayMeal) {
		this.fridayMeal = fridayMeal;
	}

	public Food getSaturdayMeal() {
		return saturdayMeal;
	}

	public void setSaturdayMeal(Food saturdayMeal) {
		this.saturdayMeal = saturdayMeal;
	}

	public OffsetDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(OffsetDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
}
