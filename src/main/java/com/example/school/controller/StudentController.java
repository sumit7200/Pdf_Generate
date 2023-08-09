package com.example.school.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.school.model.Studentt;
import com.example.school.service.StudentService;
import com.example.school.util.PdfGenerator;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@Controller

public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/save")
    public ResponseEntity<Studentt> saveStudent(@RequestBody Studentt studentt) {

        service.saveStudent(studentt);
        return new ResponseEntity<>(studentt, HttpStatus.CREATED);
    }

    @GetMapping("/pdf/students")
    public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);
        List<Studentt> studentList = service.findAllStudents();
        PdfGenerator generator = new PdfGenerator();
        generator.setStudentList(studentList);
        generator.generate(response);

    }
}

