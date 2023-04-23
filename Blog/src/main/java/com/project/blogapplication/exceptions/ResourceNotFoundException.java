package com.project.blogapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 402934271858462113L;
	private String resourcename;
	private String fieldname;
	private static String fieldValue;

	public ResourceNotFoundException(String resourcename, String fieldname, String fieldValue) {
		super(String.format("%s is not found with %s : %s ", resourcename, fieldname, fieldValue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldValue = fieldValue;
	}
	
	public static String ResourceNotFoundMessagebody(String resourcename, String fieldname, String fieldValue) {
		
		return String.format("%s is not found with %s : %s ", resourcename, fieldname, fieldValue);
	}

	public String getFieldname() {
		return fieldname;
	}

	public static String getFieldValue() {
		return fieldValue;
	}

}
