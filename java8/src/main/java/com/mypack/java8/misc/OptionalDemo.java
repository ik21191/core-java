package com.mypack.java8.misc;

import java.util.Optional;

public class OptionalDemo {

  public static void main(String[] args) {
    // way1
    Optional<String> optional = getValue(true);
    if (optional.isPresent()) {
      System.out.println("way1 : " + optional.get());
    } else {
      System.out.println("way1 value is not present");
    }

    // way2
    String value = getValue(false).orElse(null);
    if (value != null) {
      System.out.println("way2 : " + value);
    } else {
      System.out.println("way2 value is not present");
    }

    // way3 //To return a default value if Optional is empty
    value = getValue(false).orElseGet(() -> "default");
    System.out.println("way3 : " + value);

    // way4 //This will throw java.util.NoSuchElementException runtime exception
    value = getValue(true).orElseThrow();
    System.out.println("way4 : " + value);

    // way5 to throw Checked Exception
    try {
      value = getValue(false).orElseThrow(() -> new Exception("Optional is empty"));
      System.out.println("way5 : " + value);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private static Optional<String> getValue(boolean flag) {
    if (flag) {
      return Optional.of("Hello");
    }
    return Optional.empty();
  }
}
