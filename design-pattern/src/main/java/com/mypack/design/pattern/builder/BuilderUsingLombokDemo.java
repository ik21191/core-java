package com.mypack.design.pattern.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

public class BuilderUsingLombokDemo {
  public static void main(String[] ar) {
    Employee employee = Employee.builder(101).build();
    System.out.println(employee);
    employee = Employee.builder(102).firstName("Imran").build();
    System.out.println(employee);
    employee = Employee.builder(103).firstName("Vinay").lastName("Kumar").build();
    System.out.println(employee);
  }
}

@Builder
@ToString
@Getter
class Employee {
  @NonNull
  private final int empId;//mandatory field setting in the builder method
  private final String firstName;
  private final String lastName;

  public static EmployeeBuilder builder(int empId) {
    return new EmployeeBuilder().empId(empId);
  }
}