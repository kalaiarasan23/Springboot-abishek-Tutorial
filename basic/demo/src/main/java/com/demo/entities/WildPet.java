package com.demo.entities;

public class WildPet extends Pet {
	private String place;

	public WildPet() {
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}


	@Override
	public String toString() {
		return "WildPet [" + super.toString() + ", place=" + place + "]";
	}
	
	
	
}
