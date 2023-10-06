package com.quarphix.salestaxes.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6127088647065852843L;
	private  String resourceName;
	private  String fieldName;
	private  Integer integerField;
	private String stringField;
	private  Long longField;
	
	/**
	 * 
	 * @param resourceName
	 * @param fieldName
	 * @param stringField
	 */
	public ResourceNotFoundException(final String resourceName, final String fieldName, final String stringField) {
		super(String.format("%s resource with %s: '%s' not found!", resourceName, fieldName, stringField));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.stringField = stringField;
	}
	/**
	 * 
	 * @param resourceName
	 * @param fieldName
	 * @param integerField
	 */
	public ResourceNotFoundException(final String resourceName, final String fieldName, final Integer integerField) {
		super(String.format("%s resource with %s: '%s' not found!", resourceName, fieldName, integerField));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.integerField = integerField;
	}
	/**
	 * 
	 * @param resourceName
	 * @param fieldName
	 * @param longField
	 */
	public ResourceNotFoundException(final String resourceName, final String fieldName , final Long longField) {
		super(String.format("%s resource with %s: '%s' not found!", resourceName, fieldName, longField));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.longField = longField;
	}
	public ResourceNotFoundException() {
		super();
	}

}
