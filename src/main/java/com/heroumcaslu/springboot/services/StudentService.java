package com.heroumcaslu.springboot.services;

import com.heroumcaslu.springboot.error.ResourceNotFoundException;
import com.heroumcaslu.springboot.repositories.StudentRepository;

public class StudentService {
	
	private static StudentRepository studentDAO;
	
	public static void verifyIfStudentExists(Long id) {
		
		if(studentDAO.findOne(id) == null) {
			
			throw new ResourceNotFoundException("Student not found for id "+id);
			
		}
		
	}

}
