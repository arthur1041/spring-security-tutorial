package com.artcruz.securitywithspring.domain.model;

public class Student {

  private Integer id;
  private String name;

  public Student() {

  }

  public Student(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
