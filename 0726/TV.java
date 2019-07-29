package chapter05.sub;

public class TV extends Product {
	private int inch;
	private String d_type;
	
	public TV() {}
	public TV(int p_no, String p_name, int price, int count,int inch, String d_type) {
		super(p_no, p_name, price, count);
		this.inch = inch;
		this.d_type = d_type;
	}
	public String toString() {
		return super.toString()+" 인치:"+inch+" 디스플레이타입:"+d_type;

	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		if (inch>0) {
			this.inch = inch;
		}else {
			System.err.println("잘못된 인치 정보 입니다. 0이하는 입력이 불가능합니다.");
		}
	}
	public String getD_type() {
		return d_type;
	}
	public void setD_type(String d_type) {
		this.d_type = d_type;
	}
	
	
}
