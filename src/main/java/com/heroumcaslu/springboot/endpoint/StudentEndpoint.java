package com.heroumcaslu.springboot.endpoint;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heroumcaslu.springboot.model.Student;

@RestController
@RequestMapping("student")
public class StudentEndpoint {
	
	@RequestMapping(method = RequestMethod.GET, path = "/list")
	public List<Student> listAll() {
		
		return Arrays.asList(new Student("Lucas"),
				new Student("Pedro"),
				new Student("João"),
				new Student("John"));
		
	}

}
