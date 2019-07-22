package com.ssafy.java;

public class Refrigerator {
	private String p_code;
	private String p_name;
	private int price;
	private int count;
	private int capacity;
	
	public Refrigerator() {}
	
	public Refrigerator(String p_code, String p_name, int price, int count, int capacity) {
		setP_code(p_code);
		setP_name(p_name);
		setPrice(price);
		setCount(count);
		setCapacity(capacity);
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if (capacity<0) {
			System.err.println("잘못된 용량 정보입니다.");
		}else {
			this.capacity = capacity;
		}
	}

	public String toString() {
		return "제품번호:"+p_code+" 제품이름:"+p_name+" 가격:"+price
				+" 수량:"+count+" 용량(L):"+capacity;
	}

}
