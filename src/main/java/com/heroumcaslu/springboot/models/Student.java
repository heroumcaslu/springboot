package com.heroumcaslu.springboot.models;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7545970178820767127L;
	@NotEmpty(message = "O campo nome é obrigatório")
	private String name;
	@NotEmpty
	@Email
	private String email;
	
	public Student(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
