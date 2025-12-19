package com.junit5.specific;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Junit5AnnotationTest {

  @BeforeEach
  void setup() {
    System.out.println("Before each tests.");
  }

  @BeforeAll
  static void globalSetup() {
    System.out.println("Setup before all tests.");
  }

  @AfterEach
  void cleanup() {
    System.out.println("Cleanup after each test.");
  }

  @AfterAll
  static void globalCleanup() {
    System.out.println("Cleanup after all tests.");
  }

  @Test
  void testMethod1() {
    System.out.println("Test 1 executed.");
  }

  @Test
  void testMethod2() {
    System.out.println("Test 2 executed.");
  }


  @ParameterizedTest
  @ValueSource(ints = {1, 2, 4, 7, 8, 11})
  public void testIfInputPresentInTheList(int input) {
    System.out.println("Running parameterized test for " + input);
    List<Integer> list = Arrays.asList(1, 2, 4, 7, 8, 11);
    System.out.println(String.valueOf(input));
    assertTrue(list.contains(input));
  }

  // The parameterized test method
  @ParameterizedTest
  @MethodSource("provideStringsForIsPalindrome") // Refers to the static method by name
  void testIsPalindrome(String input, boolean expectedResult) {
    Assertions.assertEquals(expectedResult, isPalindrome(input));
  }

  // The static factory method that provides arguments
  private static Stream<Arguments> provideStringsForIsPalindrome() {
    return Stream.of(Arguments.arguments("level", true), 
        Arguments.arguments("madam", true),
        Arguments.arguments("animal", false), 
        Arguments.arguments("marvel", false));
  }

  // The utility method being tested (for demonstration purposes)
  public boolean isPalindrome(String input) {
    if (input == null) {
      return false;
    }
    String reversed = new StringBuilder(input).reverse().toString();
    return input.equals(reversed);
  }
}
