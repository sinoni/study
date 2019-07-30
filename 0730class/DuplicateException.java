package com.ssafy.model.dto;

public class DuplicateException extends Exception {

	public DuplicateException() {
		super("동일한 사원번호로 이미 등록되어 있습니다.");
	}
	public DuplicateException(String message) {
		super(message);
	}
	
}
