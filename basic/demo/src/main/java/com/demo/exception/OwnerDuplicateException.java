package com.demo.exception;

public class OwnerDuplicateException extends Exception{
	private static final long serialVersionUID = 1L;

	public OwnerDuplicateException(String exception) {
		super(exception);
	}
}
