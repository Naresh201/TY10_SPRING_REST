package com.te.springrest.customexception;

public class ProductException  extends RuntimeException{
	
	public ProductException(String msg) {
		super(msg);
	}

}
