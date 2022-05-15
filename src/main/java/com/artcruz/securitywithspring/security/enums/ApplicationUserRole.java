package com.artcruz.securitywithspring.security.enums;

import static com.artcruz.securitywithspring.security.enums.ApplicationUserPermission.*;

import java.util.Set;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {
  STUDENT(Sets.newHashSet()),
  ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
  ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));


  private Set<ApplicationUserPermission> permissions;

  ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
    this.permissions = permissions;
  }

  public Set<ApplicationUserPermission> getPermissions() {
    return this.permissions;
  }
}
