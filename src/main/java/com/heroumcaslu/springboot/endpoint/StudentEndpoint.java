package com.heroumcaslu.springboot.endpoint;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heroumcaslu.springboot.model.Student;
import com.heroumcaslu.springboot.util.DateUtil;

@RestController
@RequestMapping("student")
public class StudentEndpoint {
	
	@Autowired
	private DateUtil dateUtil;
	
	@RequestMapping(method = RequestMethod.GET, path = "/list")
	public List<Student> listAll() {
		
		System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return Arrays.asList(new Student("Lucas"),
				new Student("Pedro"),
				new Student("João"),
				new Student("John"));
		
	}

}
