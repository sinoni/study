package com.ssafy.model.dto;

public class CodeNotFindException extends Exception {
	public CodeNotFindException() {
		super("해당 제품번호의 제품을 찾을 수 없습니다.");
	}
	public CodeNotFindException(String message) {
		super(message);
	}
}
