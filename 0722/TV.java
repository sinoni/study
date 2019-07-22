package com.ssafy.java;

public class TV {
	private String p_code;
	private String p_name;
	private int price;
	private int count;
	private int inch;
	private String d_type;
	
	TV() {}
	TV(String p_code, String p_name, int price, int count, int inch, String d_type) {
		setP_code(p_code);
		setP_name(p_name);
		setPrice(price);
		setCount(count);
		setInch(inch);
		setD_type(d_type);
		
	}
	
	
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
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
		if (price<0) {
			System.err.println("잘못된 가격 정보입니다.");
		}else {
			this.price = price;
		}
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		if (count<0) {
			System.err.println("잘못된 수량 정보입니다.");
		}else {
			this.count = count;
		}
		
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		if (inch<0) {
			System.err.println("잘못된 인치 정보입니다.");
		}else {
			this.inch = inch;
		}
	}
	public String getD_type() {
		return d_type;
	}
	public void setD_type(String d_type) {
		this.d_type = d_type;
	}
	public String toString() {
		return "제품번호:"+p_code+" 제품이름:"+p_name+" 가격:"+price
				+" 수량:"+count+" 인치:"+inch+" 디스플레이타입:"+d_type;
	}

}
