package com.demo.exception;

public class PetNotFoundExpection extends Exception {
	private static final long serialVersionUID = 1L;

	public PetNotFoundExpection(String s) {
		super(s);
	}
}
