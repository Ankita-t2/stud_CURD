package com.ankita.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ankita.dao.StudentRepository;
import com.ankita.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public String addStudent(Student student) {
		
		Student std= studentRepository.save(student);
		
		return "student"+std.getFirstName() +" is added";
		
	
		
		
		
	}
	
	 public  List<Student> getAllStudents() {
		
		  List<Student> stds =(List<Student>) studentRepository.findAll();
		  
		return stds;
	}
	 
	public Student getStudent(Long rollNo) {
		Optional<Student>  std= studentRepository.findById(rollNo);
		return std.isPresent()? std.get():new Student();
	}

	public String deleteStudent(Long rollNo) {
		studentRepository.deleteById(rollNo);
		return "Student has been deleted";
	}

	public String updateStudent(Student student, Long rollNo) {
		Student studdep= studentRepository.findById(rollNo).get();
		if (Objects.nonNull(student.getFirstName())
	            && !"".equalsIgnoreCase(
	            		student.getFirstName())) {
			studdep.setFirstName(
					student.getFirstName());
	        }
		if (Objects.nonNull(student.getLastName())
	            && !"".equalsIgnoreCase(
	            		student.getLastName())) {
			studdep.setLastName(
					student.getLastName());
	        }
	       
	 
		if (Objects.nonNull(student.getCity())
	            && !"".equalsIgnoreCase(
	            		student.getCity())) {
			studdep.setCity(
					student.getCity());
	        }
	 
		return "student"+student.getFirstName() +" is updated";
		
		
	}
}
