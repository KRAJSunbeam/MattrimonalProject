package com.app.custexception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String mesg) {
		super(mesg);
	}
}
