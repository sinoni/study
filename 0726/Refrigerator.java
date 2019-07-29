package chapter05.sub;

public class Refrigerator extends Product {
	private int capacity;
	
	public Refrigerator() {}
	public Refrigerator(int p_no, String p_name, int price, int count,int capacity) {
		super(p_no, p_name, price, count);
		this.capacity = capacity;
	}
	public String toString() {
		return super.toString()+" 용량(L):"+capacity;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		if (capacity>0) {
			this.capacity = capacity;
		}else {
			System.err.println("잘못된 용량 정보입니다!!! 0이하로는 입력이 불가능합니다.");
		}
		
	}
	
	
	
}
