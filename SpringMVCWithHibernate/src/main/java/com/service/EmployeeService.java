package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao ed;
	
	public int storeEmployeeService(Employee emp) {
		return ed.storeEmployeeDao(emp);
	}
	
	public List<Employee> getEmployeeInfo() {
		return ed.getEmployeeDetails();
	}
}
