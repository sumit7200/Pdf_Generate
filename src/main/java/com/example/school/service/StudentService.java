package com.example.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school.Dao.StudentReposatory;
import com.example.school.model.Studentt;

@Service
public class StudentService {

	@Autowired
	private StudentReposatory repo;

	public List<Studentt> findAllStudents() {
		return repo.findAll();
	}

	public void saveStudent(Studentt student) {
		repo.save(student);
	}
}
