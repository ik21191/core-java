package com.mypack.example.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpyTest {

  @Test
  void verifySpyAndActualMethod() {
    RealClass realClass = new RealClass();
    RealClass spyRealClass = spy(realClass);

    doReturn("TEST SPY").when(spyRealClass).spyMethod();
    // below is the incorrect way of using when...thenReturn, it will call actual method.
    // when(spyRealClass.spyMethod()).thenReturn("TEST SPY");

    assertEquals(spyRealClass.spyMethod(), "TEST SPY");
    assertEquals(spyRealClass.actualMethod(), "ACTUAL");
  }

  static class RealClass {
    // Mocking this method only
    public String spyMethod() {
      System.out.println("RealClass: spyMethod() is call.");
      return "SPY";
    }

    public String actualMethod() {
      System.out.println("RealClass: actualMethod() is call.");
      return "ACTUAL";
    }
  }
}
