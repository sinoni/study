package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.CanNotFindException;
import com.ssafy.model.dto.DuplicateException;
import com.ssafy.model.dto.Employee;

public interface EmployeeDao {
	
	/**사원번호에 해당하는 사원을 검색*/
	Employee findEmployee(String empno) throws CanNotFindException;
	void add(Employee emp) throws DuplicateException;
	void update(Employee emp) throws CanNotFindException;
	void remove(String empno) throws CanNotFindException;
	void close();
	List<Employee> searchAll();

}