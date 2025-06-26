package com.demo.entities;

public class DomesticPet extends Pet {
	private String Dob;
	
	public DomesticPet() {
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	@Override
	public String toString() {
		return "DomasticPet [" + super.toString()  + ", Dob=" + Dob + "]";
	}
	
	
}
