package com.marcos.pizzaria_sistema.exceptions;

public class EntityNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntityNotFound(String msg) {
		super(msg);
	}

}
