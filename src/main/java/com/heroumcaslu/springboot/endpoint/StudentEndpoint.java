package com.heroumcaslu.springboot.endpoint;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heroumcaslu.springboot.error.CustomErrorType;
import com.heroumcaslu.springboot.model.Student;
import com.heroumcaslu.springboot.util.DateUtil;

@RestController
@RequestMapping("students")
public class StudentEndpoint {
	
	private final DateUtil dateUtil;
	
	@Autowired
	public StudentEndpoint(DateUtil dateUtil) {
		// TODO Auto-generated constructor stub
		this.dateUtil = dateUtil;
	}
	
	//@RequestMapping(method = RequestMethod.GET, path = "/list")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {
		
		//System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
		
		Student student = new Student();
		student.setId(id);
		
		int index = Student.studentList.indexOf(student);
		
		if(index == -1) {
			
			return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
		
	}

}
