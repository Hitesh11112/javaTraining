package com.coforge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.entities.Student;
import com.coforge.services.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
@PostMapping("/student")
public Student addStudent(@RequestBody Student student)
{
	return service.addStudent(student);
}
}