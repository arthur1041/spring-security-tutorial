package com.artcruz.securitywithspring.controller;

import java.util.Arrays;
import java.util.List;

import com.artcruz.securitywithspring.domain.model.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

  private static final List<Student> STUDENTS = Arrays.asList(
      new Student(1, "Lavoisier"),
      new Student(2, "Gauss"),
      new Student(3, "Newton"),
      new Student(4, "Kepler"));

  @GetMapping(path = "/{studentId}")
  public Student getStudent(@PathVariable("studentId") Integer studentId) {
    return STUDENTS.stream()
        .filter(student -> studentId.equals(student.getId()))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));
  }

}
