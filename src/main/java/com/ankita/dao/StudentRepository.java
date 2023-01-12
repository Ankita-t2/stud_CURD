package com.ankita.dao;

import org.springframework.data.repository.CrudRepository;

import com.ankita.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	

}
