package com.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import com.employee.Employee;

public class MockitoSampleTest {

  @Test
  void testService() {
    Employee employee = mock(Employee.class);

    LocalDateTime time = LocalDateTime.now();

    when(employee.getJoiningDate()).thenReturn(time);
    assertEquals(time, employee.getJoiningDate());
    verify(employee).getJoiningDate();
  }

}
