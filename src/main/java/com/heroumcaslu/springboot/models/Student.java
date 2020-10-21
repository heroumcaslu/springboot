package com.heroumcaslu.springboot.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Student extends AbstractEntity {

	private String name;
	
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
