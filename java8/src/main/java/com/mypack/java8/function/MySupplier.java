package com.mypack.java8.function;

import java.util.function.Supplier;

public class MySupplier implements Supplier<String> {
  @Override
  public String get() {
    return "Hello";
  }

  public static void main(String[] args) {
    Supplier<String> supplier = new MySupplier();
    System.out.println(supplier.get());

    supplier = () -> "Hello";

    System.out.println(supplier.get());
  }
}
