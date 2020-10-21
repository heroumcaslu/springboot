package com.heroumcaslu.springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.heroumcaslu.springboot.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findByName(String name);
	
}
