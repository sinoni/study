package com.ssafy.model.dto;

public class CanNotFindException extends Exception {
	public CanNotFindException() {
		super("해당 제품번호의 제품을 찾을 수 없습니다.");
	}
	public CanNotFindException(String message) {
		super(message);
	}
}
