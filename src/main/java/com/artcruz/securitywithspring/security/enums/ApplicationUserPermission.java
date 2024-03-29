package com.artcruz.securitywithspring.security.enums;

public enum ApplicationUserPermission {

  STUDENT_READ("student:read"),
  STUDENT_WRITE("student:write"),
  COURSE_READ("course:read"),
  COURSE_WRITE("course:write");
 
  private String permission;
 
  ApplicationUserPermission(String permission) {
    this.permission = permission;
  }

  public String getPermission() {
    return permission;
  }

  @Override
  public String toString() {
    return this.permission;
  }

}
