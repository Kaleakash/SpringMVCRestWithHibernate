package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	@RequestMapping(value="/getEmpInfo",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmpInfo() {
		System.out.println(es.getEmployeeInfo().size());
		return es.getEmployeeInfo();
	}
	
	
	@RequestMapping(value="/storeEmpInfo",consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public String storeEmpInfo(@RequestBody Employee emp) {
		if(es.storeEmployeeService(emp)>0) {
			return "Record stored successfully";
		}else {
			return "Record is not store";
		}
	}
	
}
