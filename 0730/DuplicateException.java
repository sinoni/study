package com.ssafy.model.dto;

public class DuplicateException extends Exception{
	public DuplicateException() {
		super("이미 존재하는 상품입니다!!! 동일한 제품번호로 이미 등록되어 있습니다.");
	}
	public DuplicateException(String message) {
		super(message);
	}
}
