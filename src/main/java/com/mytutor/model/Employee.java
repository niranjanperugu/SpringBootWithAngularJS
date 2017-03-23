package com.mytutor.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	@XmlElement
	private String name;
	@XmlElement
	private String age;
	@XmlElement
	private String empId;
	@XmlElement
	private String address;

	public Employee() {

	}

	public Employee(String name, String age, String empId, String address) {
		this.name = name;
		this.age = age;
		this.empId = empId;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
