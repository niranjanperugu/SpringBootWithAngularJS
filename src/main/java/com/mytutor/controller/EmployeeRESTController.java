package com.mytutor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytutor.model.EmployeeVO;

@RestController
@RequestMapping("data")
public class EmployeeRESTController {
	// Local storage of employees for demo; You will use database here
	private static List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
	Map<String,List<EmployeeVO>> map=new HashMap<String,List<EmployeeVO>>();

	// add some employees here
	public EmployeeRESTController() {
		EmployeeVO empOne = new EmployeeVO(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
		EmployeeVO empTwo = new EmployeeVO(2, "Amit", "Singhal", "asinghal@yahoo.com");
		EmployeeVO empThree = new EmployeeVO(3, "Kirti", "Mishra", "kmishra@gmail.com");

		employees.add(empOne);
		employees.add(empTwo);
		employees.add(empThree);
	}

	// Utility methods for getting employee by id
	private EmployeeVO _getEmployeeById(int id) {
		for (EmployeeVO e : employees) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	/**
	 * HTTP GET - Get all employees
	 */
	@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<EmployeeVO> getAllEmployeesJSON() {
		return employees;
	}

	/**
	 * HTTP POST - Create new Employee
	 */
	@RequestMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeVO employee) {
		employee.setId(employees.size() + 1);
		employees.add(employee);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	/**
	 * HTTP PUT - Update employee
	 */
	@RequestMapping(value = "/employees/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<EmployeeVO> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeVO employee) {
		EmployeeVO emp = _getEmployeeById(id);
		if (emp != null) {
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmail(employee.getEmail());
			return new ResponseEntity<EmployeeVO>(emp, HttpStatus.OK);
		}
		return new ResponseEntity<EmployeeVO>(HttpStatus.NOT_FOUND);
	}

	/**
	 * HTTP DELETE - Delete employee
	 */
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		EmployeeVO employee = _getEmployeeById(id);
		if (employee != null) {
			employees.remove(employee);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
}