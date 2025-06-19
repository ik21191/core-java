package com.mypack.java8.function;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<String> {
  
  @Override
  public void accept(String value) {
    System.out.println("Value is: " + value);
  }

  public static void main(String[] args) {
    Consumer<String> consumer = new MyConsumer();
    consumer.accept("Hello");
    
    consumer = (value)->System.out.println("Value is: " + value);
    consumer.accept("Hello");
  }
}
