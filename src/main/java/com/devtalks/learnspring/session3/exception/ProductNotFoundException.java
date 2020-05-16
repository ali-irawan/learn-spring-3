package com.devtalks.learnspring.session3.exception;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(Long id) {
		super("Cant find product with specified ID: " + id);
	}
}
