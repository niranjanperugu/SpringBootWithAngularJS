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


import com.mytutor.model.Tutor;;



@RestController
@RequestMapping("tutors")
public class TutorController {

	List<Tutor> tutors = new ArrayList<Tutor>();

	@RequestMapping(value = "/tutor", method = RequestMethod.GET, produces = "application/json")
	public List<Tutor> getTutors() {

		return tutors;

}
	@RequestMapping(value = "/tutor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Tutor> registerTutor(@RequestBody Tutor tutor) {
		tutor.setId(tutors.size() + 1);
		tutors.add(tutor);
		return tutors;
	}

	private Tutor _getTutorById(int id) {
		for (Tutor t : tutors) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}
	/**
	 * HTTP PUT - Update Tutor
	 */
	@RequestMapping(value = "/tutor/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<Tutor> updateEmployee(@PathVariable("id") int id,
			@RequestBody Tutor tutor) {
		Tutor t = _getTutorById(id);
		if (t != null) {
			t.setName(tutor.getName());
			t.setEmail(tutor.getEmail());
			t.setAge(tutor.getAge());
			t.setQualification(tutor.getQualification());
			t.setTeachingSubjects(tutor.getTeachingSubjects());
			t.setMobileNo(tutor.getMobileNo());
			t.setAddress(tutor.getAddress());
			t.setId(tutor.getId());
			return new ResponseEntity<Tutor>(t, HttpStatus.OK);
		}
		return new ResponseEntity<Tutor>(HttpStatus.NOT_FOUND);
	}
	
/**
 * HTTP DELETE - Delete Tutor
 */
@RequestMapping(value = "/tutor/{id}", method = RequestMethod.DELETE)
public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
	Tutor t = _getTutorById(id);
	if (t != null) {
		tutors.remove(t);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
}
}
