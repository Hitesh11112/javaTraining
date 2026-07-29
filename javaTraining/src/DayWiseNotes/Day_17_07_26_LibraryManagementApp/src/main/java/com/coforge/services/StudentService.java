package com.coforge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.entities.Student;
import com.coforge.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;
	public Student addStudent(Student student)
	{
		return repository.save(student);
	}
}