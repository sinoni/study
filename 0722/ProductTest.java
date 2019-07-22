package com.ssafy.java;

public class ProductTest {
	public static void main(String[] args) {
		TV t1 = new TV("00010", "abcTV", 1000000, 55, 60, "OLED");
		TV t2 = new TV("00020", "defTV", 2000000, 25, 30, "LED");
		Refrigerator r1 = new Refrigerator("00030", "abcReF", 2000000, 15, 200);
		Refrigerator r2 = new Refrigerator("00040", "defReF", 3000000, 10, 100);
		Refrigerator r3 = new Refrigerator("00050", "ghiReF", 3000000, 10, 100);
		System.out.println("================================ TV 정보================================");
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println("================================냉장고정보================================");
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		System.out.println(r3.toString());
	}

}
