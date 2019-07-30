package com.ssafy.model.dto;

public class CanNotFindException extends Exception {

	public CanNotFindException() {
		super("사원번호에 해당하는 사원을 찾을 수 없습니다.");
	}
	public CanNotFindException(String message) {
		super(message);
	}

}
