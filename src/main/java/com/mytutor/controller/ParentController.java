package com.mytutor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytutor.model.EmployeeVO;
import com.mytutor.model.Parent;

@RestController
@RequestMapping("parents")
public class ParentController {
	List<Parent> parents = new ArrayList<Parent>();

	@RequestMapping(value = "/parent", method = RequestMethod.GET, produces = "application/json")
	public List<Parent> getEmployees() {

		return parents;

	}

	@RequestMapping(value = "/parent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Parent> registerParent(@RequestBody Parent parent) {
		parent.setId(parents.size() + 1);
		parents.add(parent);
		return parents;
	}

	private Parent _getParentById(int id) {
		for (Parent p : parents) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	/**
	 * HTTP PUT - Update employee
	 */
	@RequestMapping(value = "/parent/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<Parent> updateEmployee(@PathVariable("id") int id,
			@RequestBody Parent parent) {
		Parent p = _getParentById(id);
		if (p != null) {
			p.setName(parent.getName());
			p.setAddress(parent.getAddress());
			p.setEmail(parent.getEmail());
			p.setId(parent.getId());
			p.setIntrestedSubjects(parent.getIntrestedSubjects());
			p.setMobileNo(parent.getMobileNo());
			p.setRelation(parent.getRelation());
			p.setStudentQualification(parent.getStudentQualification());
			p.setStudentQualification(parent.getStudentQualification());
			return new ResponseEntity<Parent>(p, HttpStatus.OK);
		}
		return new ResponseEntity<Parent>(HttpStatus.NOT_FOUND);
	}

	/**
	 * HTTP DELETE - Delete employee
	 */
	@RequestMapping(value = "/paraent/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		Parent p = _getParentById(id);
		if (p != null) {
			parents.remove(p);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
}
