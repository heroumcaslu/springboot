package com.heroumcaslu.springboot.endpoint;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.heroumcaslu.springboot.error.ResourceNotFoundException;
import com.heroumcaslu.springboot.models.Student;
import com.heroumcaslu.springboot.repositories.StudentRepository;

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

		verifyIfStudentExists(id);
		
		Student student = studentDAO.findOne(id);

		return new ResponseEntity<>(student, HttpStatus.OK);

	}
	
	@GetMapping(path = "/findByName/{name}")
	public ResponseEntity<?> findStudentByName(@PathVariable String name) {
		
		return new ResponseEntity<>(studentDAO.findByName(name), HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/findByNameIgnoreCase/{name}")
	public ResponseEntity<?> findStudentByNameIgnoreCase(@PathVariable String name) {
		
		return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
		
	}

	//Not idempotent
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	@Transactional
	public ResponseEntity<?> save(@Valid @RequestBody Student student) {

		return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);

	}
	
	//@RequestMapping(method = RequestMethod.DELETE)
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {

		verifyIfStudentExists(id);
		studentDAO.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	//@RequestMapping(method = RequestMethod.PUT)
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Student student) {

		verifyIfStudentExists(student.getId());
		studentDAO.save(student);// com o id é atualizado, sem o id é criado
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	//Método na camada de serviços
	private void verifyIfStudentExists(Long id) {
		
		if (studentDAO.findOne(id) == null) {
			
			throw new ResourceNotFoundException("Student not found for id: "+id);
			
		}
		
	}

}
