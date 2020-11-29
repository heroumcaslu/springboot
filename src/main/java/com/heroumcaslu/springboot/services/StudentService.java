package com.heroumcaslu.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroumcaslu.springboot.error.ResourceNotFoundException;
import com.heroumcaslu.springboot.repositories.StudentRepository;

@Service
public class StudentService {
	
	private static StudentRepository studentDAO;
	
	@Autowired
	public StudentService(StudentRepository studentDAO) {
		// TODO Auto-generated constructor stub
		StudentService.studentDAO = studentDAO;
	}
	
	public static void verifyIfStudentExists(Long id) {
		
		if(studentDAO.findOne(id) == null) {
			
			throw new ResourceNotFoundException("Student not found for id "+id);
			
		}
		
	}

}
