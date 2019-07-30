package com.ssafy.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.CanNotFindException;
import com.ssafy.model.dto.DuplicateException;
import com.ssafy.model.dto.Employee;

public class EmployeePolyManager implements EmployeeDao {

	/**일반 사원을 저장하는 배열*/
	private List<Employee> emps;
	private String fileName="employee.txt";
	public EmployeePolyManager() {
		emps = new LinkedList<Employee>();
		load();
	}
	public void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file = null;
		try {
			file = new File(fileName);
			if (file.exists() && file.canRead()) {
				fis = new FileInputStream(file);	//fis = new FileInputStream(fileName);도 상관x
				ois = new ObjectInputStream(fis);
				emps = (List) ois.readObject();		//file을 한줄로 읽어서 넣음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			fis->ois 순서로 열었으면 닫을땐 반대로 ois->fis순서로~
			if(ois!=null)try {ois.close();} catch (Exception e2){}
			if(fis!=null)try {fis.close();} catch (Exception e2){}
		}
	}
	private void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(emps);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(oos!=null) try {oos.close();}catch(Exception e2) {}
			if(fos!=null) try {fos.close();}catch(Exception e2) {}
		}
	}
	
	/**
	 * 사원번호에 해당하는 사원이 저장된 index를 리턴
	 * @param empno	찾을 사원의 사원번호
	 * @return		사원번호에 해당하는 사원을 찾은 경우 사원의 index를 리턴
	 * 				못찾은 경우 -1을 리턴
	 */
	public int findIndex(String empno) {
		if (empno != null) {
			for (int i = 0; i < emps.size(); i++) {
				Employee emp = emps.get(i);
				if (empno.equals(emp.getEmpno())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 리턴 타입에 다형성을 적용
	 * 모든 sub타입은 super타입으로 자동 형변환 되므로 리턴타입을 super타입으로
	 * 선언하면 sub타입의 객체도 리턴할 수 있다.
	 * @throws CanNotFindException 
	 */
	public Employee findEmployee(String empno) throws CanNotFindException {
		int index = findIndex(empno);
		if(index >-1) {
			return emps.get(index);
		}else {
			String msg = String.format("%s번 사원번호는 등록되지 않은 사원번호입니다.", empno);
			
			throw new CanNotFindException(msg);
		}
	}
	public void add(Employee emp) throws DuplicateException {
		System.out.println("Employee 등록..........");
		if (emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if (index>-1) {
				String msg = String.format("%s번 사원번호는 이미 등록된 번호입니다.", empno);
				throw new DuplicateException(msg);
//				throw new DuplicateException(String.format("%s번 사원번호는 이미 등록된 번호입니다.", empno));
			}else {
				emps.add(emp);
			}
		}
	}
	public void update(Employee emp) throws CanNotFindException {
		if (emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if (index > -1) {
				emps.set(index, emp);	//update됨!
				return;
			}else {
				throw new CanNotFindException("사원번호에 해당하는 사원이 등록되지 않아 수정할 수 없습니다.");
			}
		}else {
			throw new CanNotFindException("수정할 사원 정보를 입력해주세요.");
		}
	}
	public void remove(String empno) throws CanNotFindException {
		int index = findIndex(empno);
		if (index >-1) {
			emps.remove(index);
		}else {
			throw new CanNotFindException("사원번호에 해당하는 사원이 등록되지 않아 삭제할 수 없습니다.");
		}
		save();
	}
	public void close() {
//		save();
		System.exit(0); //JVM종료
	}
	public List<Employee> searchAll() {		//get대신 searchAll
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
}






