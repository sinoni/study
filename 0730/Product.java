package com.ssafy.model.dto;

import java.io.Serializable;

public class Product implements Cloneable, Serializable{
	private int p_no;
	private String p_name;
	private int price;
	private int count;
	
	public Product() {}
	public Product(int p_no, String p_name, int price, int count) {
		setP_no(p_no);
		setP_name(p_name);
		setPrice(price);
		setCount(count);
		
	}
	public String toString() {
		return "제품번호:"+p_no+" 제품이름:"+p_name+" 가격:"+price
				+" 수량:"+count;


	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if (price>0) {
			this.price = price;
		}else {
			System.err.println("잘못된 가격정보입니다!!! 0원 이하로 가격을 설정할 수 없습니다.");
		}
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		if (count>=0) {
			this.count = count;
		}else {
			System.err.println("잘못된 수량 정보입니다!!! 0이상 수량을 입력해주세요.");
		}
		
	}
	

}
