package com.ssafy.model.dto;

import java.io.Serializable;

											//출력하려는 대상이 반드시 Serializable이어야 한다.
public class Employee implements Cloneable, Serializable{	//interface를 상속	받을때 implements쓴다.
	private String empno;
	private String name;
	private int salary;
	
	public Employee() {}
	public Employee(String empno, String name, int salary) {
		setEmpno(empno);
		setName(name);
		setSalary(salary);
	}
	
	/**
	 * 객체의 내용을 문자열로 리턴하는 기능
	 * 	- System.out으로 객체를 출력할 때 toString()가 호출된다.
	 * 	- 문자열+ 객체	=> 객체의 toString()가 호출되서 문자열에 연결된다.
	 * 	- Override하지 않으면 클래스이름@hashcode가 리턴된다.
	 * 	- 필요시에 Override
	 */
	@Override
	public String toString() {	
		StringBuilder builder = new StringBuilder(50);	//상황에 따라 크기 지정 부족하면 늘리고~
		builder.append("Employee [empno=").append(empno).append(", name=").append(name).append(", salary=")
				.append(salary).append("]");
		return builder.toString();
	}
	
	/**
	 * 객체의 내용을 비교하는 기능
	 * 	- 반드시 Override를 해야 객체 내용을 비교할 수 있다.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj !=null && obj instanceof Employee) {
			Employee emp = (Employee) obj;
			if (empno != null && empno.equals(emp.empno)) {
				return true;
			}
		}
		return false;
	}
	

	/**
	 * hashCode	:객체의 참조값을 리턴하는 기능
	 * 
	 * 	- 필요시 Override
	 * 	- Override를 해도 객체의 실제 hashCode는 변하지 않는다.
	 */
	@Override
	public int hashCode() {
		int empnoHash = empno !=null ? empno.hashCode() : 1;
		int nameHash = name !=null ? name.hashCode() : 1;
		return empnoHash ^ nameHash ^ salary;
	}
	
	/**
	 * 객체의 내용이 똑같은 객체를 생성해서 리턴
	 * 	- Object에서 protected로 선언했기 때문에 함수를 사용하려면 반드시 Override 해야한다.
	 * 	- Cloneable 인터페이스를 구현해야 한다. => implements Cloneable~
	 * 	  => Cloneable 인터페이스를 구현하지 않으면  CloneNotSupportesException이 발생한다.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		if (salary<100) {
			this.salary = 100;
		}else {
			this.salary = salary;
		}
	}
	
	

}
