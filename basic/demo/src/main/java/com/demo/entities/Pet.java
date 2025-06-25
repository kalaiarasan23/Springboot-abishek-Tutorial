package com.demo.entities;

import com.demo.enumValue.Gender;

public class Pet {
	private int id;
	private String name;
	private Gender gender;
	private Owner owner;
	private static int inc;
	public Pet() {
		id=++inc;
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", gender=" + gender +"]";
	}
	
	
	
}
