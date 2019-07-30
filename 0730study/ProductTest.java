package com.ssafy.model.dto;

import com.ssafy.model.dao.ProductMgrImpl;

public class ProductTest {
	public static void main(String[] args) {
		
		ProductMgrImpl product = new ProductMgrImpl();
		
		
		product.add(new TV(1001, "abcTV", 1000000, 55, 60, "OLED"));
		product.add(new TV(1002, "defTV", 2000000, 25, 30, "LED"));
		product.add(new TV(1002, "ghiTV", 3000000, 25, 30, "LCD"));
		product.add(new Refrigerator(3001, "abcReF", 2000000, 15, 600));
		product.add(new Refrigerator(3002, "defReF", 3000000, 10, 700));
		product.add(new Refrigerator(3003, "ghiReF", 3000000, 10, 300));
		System.out.println("=================등록 후 결과...상품 정보를 전체검색합니다!=================");
		for(Product prd : product.searchAll()) {
			System.out.println(prd);
		}
		
		
		System.out.println("===========================상품번호 검색 결과==========================");
		System.out.println(product.findProduct(1001));
		System.out.println(product.findProduct(1002));
		System.out.println(product.findProduct(3001));
		System.out.println(product.findProduct(3002));
		System.out.println(product.findProduct(3003));
		
		System.out.println("===========================상품명  검색 결과===========================");
		for(Product prd : product.findProduct_name("TV")) {
			System.out.println(prd);
		}
		
		System.out.println("=========================TV 정보를 검색합니다!========================");
		for(Product prd : product.Search("TV")) {
			System.out.println(prd);
		}
		System.out.println("==================Refrigerator상품 정보를 검색합니다!==================");
		for(Product prd : product.Search("Refrigerator")) {
			System.out.println(prd);
		}
	
		System.out.println("=================3003삭제 후 결과...상품 정보를 전체검색합니다!=================");
		product.remove(3003);
		for(Product prd : product.searchAll()) {
			System.out.println(prd);
		}

		System.out.println("===========================전체 재고 상품 금액==========================");
		System.out.println("전체 재고 상품 가격: "+product.sumPrice());
		
		System.out.println("=======================400L 이상 Refrigerator=====================");
		for(Product prd : product.findRefrigerator400()) {
			System.out.println(prd);
		}
		
		System.out.println("===========================50Inch 이상 TV=========================");
		for(Product prd : product.findTV50()) {
			System.out.println(prd);
		}
		
		System.out.println("==============================가격정보 수정============================");
		product.updatePrice(1001, 5000000);
		System.out.println(product.findProduct(1001));

	}

}
