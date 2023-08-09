package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.school.model.Studentt;
import com.example.school.service.StudentService;

@SpringBootTest
class SchoolApplicationTests implements CommandLineRunner {

	@Autowired
	public StudentService service;

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 11; i++) {
			Studentt student = new Studentt();
			student.setName("Student " + i);
			student.setSection("Section " + i);
			service.saveStudent(student);
		}

	}

}
