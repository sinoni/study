package chapter05.sub;

public class ProductTest {
	public static void main(String[] args) {
		
		ProductMgr product = new ProductMgr();
		
		product.add(new TV(1001, "abcTV", 1000000, 55, 60, "OLED"));
		product.add(new TV(1002, "defTV", 2000000, 25, 30, "LED"));
		product.add(new TV(1002, "ghiTV", 3000000, 25, 30, "LCD"));
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
		
		System.out.println("=======================TV/Refrigerator 재고 금액=====================");
		product.Price("TV");
		product.Price("Refrigerator");
		
		System.out.println("=======================TV/Refrigerator 재고 수량=====================");
		product.Count("TV");
		product.Count("Refrigerator");
		
		System.out.println("==============================TV평균인치============================");
		System.out.println("TV재고의 평균 인치: "+ product.avgInch()+"Inch");
		System.out.println("=============================냉장고 리터 합계==========================");
		System.out.println("냉장고의 리터 합계: "+ product.sumLiter()+"L");
		System.out.println("===========================상품명, 금액으로 검색========================");
		for (int i = 0; i < product.searchNamePrice("TV", 2500000).length; i++) {
			System.out.println(product.searchNamePrice("TV", 2500000)[i]);
		}

	}

}
