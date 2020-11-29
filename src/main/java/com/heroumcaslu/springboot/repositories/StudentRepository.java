package com.heroumcaslu.springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.heroumcaslu.springboot.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findByName(String name);

	List<Student> findByNameIgnoreCaseContaining(String name);
	
	/* Exemplo de query
	@Query(value = "SELECT C.* FROM table C JOIN table2 CC ON (C.field = CC.field) WHERE  CC.field = :codFilial", nativeQuery = true)
	Empresa recuperaEmpresa(@Param("codFilial") String codEmpresa);
	*/
	
}
