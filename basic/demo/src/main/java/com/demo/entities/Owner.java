package com.demo.entities;

import com.demo.enumValue.Gender;

public class Owner {
	private Integer id;
	private String name,city,state;
	private int age;
	private Gender gender;
	private Pet pet;
	private static int inc; 
	public Owner() {
		id=++inc;
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", \n\t" +pet+ "]";
	}
	
	
}
