package com.ankita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ankita.model.Student;
import com.ankita.service.StudentService;

@RestController
public class Studentcontroller {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	public String addStudent( @RequestBody Student student) {
		String result=studentService.addStudent(student);
		
		return result;
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{roll-no}")
	public Student getStudent(Long rollNo) {
		return studentService.getStudent(rollNo);
	}
	@PutMapping("/student")
	public String updateStudent( @RequestBody Student student,@PathVariable("id") Long rollNo) {
		String resul=studentService.updateStudent(student,rollNo);
		
		return resul;
	}
	@DeleteMapping("/student/{roll-no}")
	public String deleteStudent(@PathVariable("roll-no") Long rollNo) {
		return studentService.deleteStudent(rollNo);
	}
	
	

}
