package com.artcruz.securitywithspring.controller;

import java.util.Arrays;
import java.util.List;

import com.artcruz.securitywithspring.domain.model.Student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagmentController {
  
  private static final List<Student> STUDENTS = Arrays.asList(
    new Student(1, "Lavoisier"),
    new Student(2, "Gauss"),
    new Student(3, "Newton"),
    new Student(4, "Kepler"),
    new Student(5, "Anna Smith"));

  @GetMapping
  public List<Student> getAllStudents() {
    return STUDENTS;
  }

  @PostMapping
  public void registerNewStudent(Student student) {
    System.out.println(student);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Integer studentId) {
    System.out.println(studentId);
  }

  @PutMapping(path = "{studentId}")
  public void updateStudent(@PathVariable("studentId") Integer studentId, Student student) {
    System.out.println(String.format("%s %s", student, student));
  }
}
