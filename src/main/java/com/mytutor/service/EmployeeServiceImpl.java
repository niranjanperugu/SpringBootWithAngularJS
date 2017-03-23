package com.mytutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytutor.dao.EmployeeServiceDao;
import com.mytutor.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeServiceDao employeeServiceDao;
	/* (non-Javadoc)
	 * @see com.rest.employee.service.EmployeeServiceInterface#getEmployee()
	 */
	@Override
	public List<Employee> getEmployee(){
		return employeeServiceDao.getEmployees();
		
	}
}
