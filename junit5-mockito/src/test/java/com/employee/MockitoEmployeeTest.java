package com.employee;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

public class MockitoEmployeeTest {
  @Test
  void testService() {
    Employee employee = new Employee();
    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    EmployeeService employeeSevice = new EmployeeService(employeeRepository);

    when(employeeRepository.save(any(Employee.class))).then(returnsFirstArg());
    Employee newEmployee = employeeSevice.create(employee);

    assertNotNull(newEmployee.getJoiningDate());
  }
}
