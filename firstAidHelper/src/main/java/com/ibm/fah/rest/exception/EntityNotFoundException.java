package com.ibm.fah.rest.exception;

public class EntityNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(Class<?> entityClass, Object id) {
		super(String.format("%s was not found for parameter %s", entityClass.getSimpleName(), id));
	}
	
	public EntityNotFoundException(Class<?> entityClass) {
		super("No entities were found in the database.");
	}
}
