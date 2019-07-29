package chapter05.sub;


import java.util.Arrays;

public class ProductMgr {
	
	private Product[] prds;
	private int prdIndex;
	
	public ProductMgr() {
		prds = new Product[10];
	}
	
	public int findIndex(int p_no) {
		if (p_no > 0) {
			for (int i = 0; i < prdIndex; i++) {
				if (p_no==(prds[i].getP_no())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void findProduct_name(String p_name) {
		if (p_name != null) {
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i].getP_name().contains(p_name)) {
					System.out.println(prds[i].toString());
				}
			}
		}
		
	}
	
	public Product findProduct(int p_no) {
		int index = findIndex(p_no);
		if (index>-1) {
			return prds[index];
		}else {
			return null;
		}
	}
	/*
	public Product findProduct(String p_name) {
		int index = findIndex(p_name);
		if (index>-1) {
			return prds[index];
		}else {
			return null;
		}
	}*/
	
	public void SearchAll() {
		for (int i = 0; i < prdIndex; i++) {
			System.out.println(prds[i].toString());	//virtual invocation
		}
	}
	
	public void Search(String type) {
		if (type == "TV") {
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i] instanceof TV) {
					System.out.println(prds[i].toString());
				}
			}
		}else if (type == "Refrigerator") {
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i] instanceof Refrigerator) {
					System.out.println(prds[i].toString());
				}
			}
		}else {

			System.err.println("잘못된 상품 타입입니다. 타입은 TV/Refrigerator 두 가지 입니다!!!");
		}
	}
	
	
	public void add(Product prd) {
		System.out.println("Product 등록!!!......");
		if (prd != null) {
			int p_no = prd.getP_no();
			int index = findIndex(p_no);
			if (index<-1) {
				System.err.printf("%s 제품번호는 이미 등록된 번호입니다.", prd);
			}else {
				if (prdIndex >= prds.length) {	//배열이 꽉찼기 때문에 배열 크기를 변경해준다.
					prds=Arrays.copyOf(prds, prdIndex+5);
				}
				prds[prdIndex++] = prd;
			}
		}
	}
	
	public void remove(int p_no) {
		int index = findIndex(p_no);
		if (index >-1) {
			prds[index] =  prds[--prdIndex];
		}else {
			System.out.println("상품번호에 해당하는 제품이 등록되지 않아 삭제할 수 없습니다.");
		}
	}
	public void sumPrice() {
		
		for (int i = 0; i < prdIndex; i++) {
			int sumPrice = 0;
			sumPrice=prds[i].getPrice()*prds[i].getCount();
			System.out.println("상품번호"+prds[i].getP_no()+"의 전체 재고 상품 금액:"+sumPrice+"원");
		}
		
	}
	
	public int[] Price(String productType) {
		int[] result = null;
		int n = 0;
		if (productType == "TV") {
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i] instanceof TV) {
					System.out.printf("제품명: %s  \t1개 당 가격:%d\n", prds[i].getP_name(), prds[i].getPrice());
					n++;
				}
			}
			result=new int[n];
			n=0;
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i] instanceof TV) {
					result[n]=prds[i].getPrice();
					n++;
				}
			}
		}else if(productType == "Refrigerator") {
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i] instanceof Refrigerator) {
					System.out.printf("제품명: %s  \t1개 당 가격:%d\n", prds[i].getP_name(), prds[i].getCount());
					n++;
				}
			}
			result=new int[n];
			n=0;
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i] instanceof Refrigerator) {
					result[n]=prds[i].getPrice();
					n++;
				}
			}
		}
		return result;
	}
	
	public int[] Count(String productType) {
		int[] result = null;
		int n = 0;
		if (productType == "TV") {
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i] instanceof TV) {
					System.out.printf("제품명: %s  \t수량:%d\n", prds[i].getP_name(), prds[i].getCount());
					n++;
				}
			}
			result=new int[n];
			n=0;
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i] instanceof TV) {
					result[n]=prds[i].getCount();
					n++;
				}
			}
		}else if(productType == "Refrigerator") {
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i] instanceof Refrigerator) {
					System.out.printf("제품명: %s  수량:%d\n", prds[i].getP_name(), prds[i].getPrice());
					n++;
				}
			}
			result=new int[n];
			n=0;
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i] instanceof Refrigerator) {
					result[n]=prds[i].getCount();
					n++;
				}
			}
		}
		return result;
	}
	
	public double avgInch() {
		TV t=null;
		double result = 0;
		int n = 0;
		for (int i = 0; i < prdIndex; i++) {
			if (prds[i] instanceof TV) {
				t = (TV)prds[i];
				result+=t.getInch();
				n++;
			}
		}
		result=result/n;
		return result;
	}
	public int sumLiter() {
		Refrigerator r=null;
		int result = 0;
		for (int i = 0; i < prdIndex; i++) {
			if (prds[i] instanceof Refrigerator) {
				r = (Refrigerator)prds[i];
				result+=r.getCapacity();

			}
		}
		return result;
	}
	
	public Product[] searchNamePrice(String p_name, int price) {
		Product[] p = null;
		int n=0;
		if (p_name != null) {
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i].getP_name().contains(p_name)) {
					if (prds[i].getPrice()<price) {
						n++;
					}
				}
			}
			p = new Product[n];
			n=0;
			for (int i = 0; i < prdIndex; i++) {
				if (prds[i].getP_name().contains(p_name)) {
					if (prds[i].getPrice()<price) {
						p[n] = prds[i];
						n++;
					}
				}
			}
		}
		return p;
	}


}
