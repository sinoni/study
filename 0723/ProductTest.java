package com.ssafy.java;

public class ProductTest {
	public static void main(String[] args) {
		
		ProductMgr product = new ProductMgr();
		
		product.add(new TV(1001, "abcTV", 1000000, 55, 60, "OLED"));
		product.add(new TV(1002, "defTV", 2000000, 25, 30, "LED"));
		product.add(new Refrigerator(3001, "abcReF", 2000000, 15, 200));
		product.add(new Refrigerator(3002, "defReF", 3000000, 10, 100));
		product.add(new Refrigerator(3003, "ghiReF", 3000000, 10, 100));
		System.out.println("=================등록 후 결과...상품 정보를 전체검색합니다!=================");
		product.SearchAll();
		
		System.out.println("===========================상품번호 검색 결과==========================");
		System.out.println(product.findProduct(1001));
		System.out.println(product.findProduct(1002));
		System.out.println(product.findProduct(3001));
		System.out.println(product.findProduct(3002));
		System.out.println(product.findProduct(3003));
		
		System.out.println("===========================상품명  검색 결과===========================");
		product.findProduct_name("TV");

		product.findProduct_name("abcReF");
		product.findProduct_name("defReF");
		product.findProduct_name("ghi");
		
		
		System.out.println("=========================TV 정보를 검색합니다!========================");
		product.Search("TV");
		System.out.println("==================Refrigerator상품 정보를 검색합니다!==================");
		product.Search("Refrigerator");
	
		System.out.println("=================삭제 후 결과...상품 정보를 전체검색합니다!=================");
		product.remove(3003);
		product.SearchAll();

		System.out.println("===========================전체 재고 상품 금액==========================");
//		System.out.println(product.sumPrice());
		product.sumPrice();
		
		
		
		

	}

}
