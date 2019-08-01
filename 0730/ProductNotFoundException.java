package com.ssafy.model.dto;

public class ProductNotFoundException extends Exception{
	public ProductNotFoundException() {
		super("상품이 존재하지 않습니다.");
	}
	public ProductNotFoundException(String message) {
		super(message);
	}

}
