package com.mypack.java8.function;

import java.util.function.BiConsumer;
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
    
    //BiConsumer
    BiConsumer<Integer, String> biConsumer = (val1, val2) -> 
    System.out.println("\nBiConsumer \nID : " + val1 + "\tName :" + val2);
    biConsumer.accept(1001, "Imran Khan");
  }
}
