package com.heroumcaslu.springboot.endpoint;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heroumcaslu.springboot.error.CustomErrorType;
import com.heroumcaslu.springboot.models.Student;
import com.heroumcaslu.springboot.repositories.StudentRepository;
import com.heroumcaslu.springboot.util.DateUtil;

@RestController
@RequestMapping("students")
public class StudentEndpoint {

	private final StudentRepository studentDAO;

	@Autowired
	public StudentEndpoint(StudentRepository studentDAO) {
		// TODO Auto-generated constructor stub
		this.studentDAO = studentDAO;
	}

	// @RequestMapping(method = RequestMethod.GET, path = "/list")
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<?> listAll() {

		// System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return new ResponseEntity<>(studentDAO.findAll(), HttpStatus.OK);

	}

	//@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {

		Student student = studentDAO.findOne(id);

		if (student == null) {

			return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<>(student, HttpStatus.OK);

	}

	//Not idempotent
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Student student) {

		return new ResponseEntity<>(studentDAO.save(student), HttpStatus.OK);

	}
	
	//@RequestMapping(method = RequestMethod.DELETE)
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {

		studentDAO.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	//@RequestMapping(method = RequestMethod.PUT)
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Student student) {

		studentDAO.save(student);// com o id é atualizado, sem o id é criado
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
