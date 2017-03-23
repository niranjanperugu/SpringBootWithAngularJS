package com.mytutor.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mytutor.model.Employee;

@Repository("employeeServiceDao")
public class EmployeeServiceDaoImpl implements EmployeeServiceDao {

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Niranjan", "24", "100", "Kodur"));
		employees.add(new Employee("Aswarth", "24", "100", "KDP"));
		employees.add(new Employee("Kiran", "24", "100", "HYD"));
		employees.add(new Employee("Dileep", "24", "100", "ADB"));
		employees.add(new Employee("Naresh", "24", "100", "Kodur"));
		return employees;
	}

}
