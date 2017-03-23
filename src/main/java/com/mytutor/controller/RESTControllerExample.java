package com.mytutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mytutor.model.Employee;
import com.mytutor.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class RESTControllerExample {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/all", method = RequestMethod.GET,headers = {"Accept:text/html,application/xhtml+xml,application/xml"}, produces="application/xml")
	public List<Employee> getEmployees() {

		return employeeService.getEmployee();

	}

}
