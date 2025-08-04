package com.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UtilsTest {
  @Test
  public void testStaticMethod() {
    // mock the static method of the Utils class
    Mockito.mockStatic(Utils.class);
    Mockito.when(Utils.getString()).thenReturn("Mocked string");

    // create an instance of the class that calls the static method
    CallUtils callUtils = new CallUtils();
    assertEquals("Mocked string", callUtils.getStringFromUtils());
  }
}
