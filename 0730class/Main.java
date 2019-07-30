package com.ssafy;

import com.ssafy.model.dao.EmployeeDao;
import com.ssafy.model.dao.EmployeePolyManager;
import com.ssafy.view.EmployeeUI;

public class Main {
	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeePolyManager();
		EmployeeUI 	mainView = new EmployeeUI();
		mainView.setModel(dao);
	}

}
