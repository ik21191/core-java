package com.mypack.java8.function;

import java.util.function.BiFunction;
import java.util.function.Function;

//Function<T, R> : T :- Input type, R :- Return type 
public class MyFunction implements Function<String, Integer> {
  
  @Override
  public Integer apply(String value) {
    return value.length();
  }

  public static void main(String[] args) {
    Function<String, Integer> function = new MyFunction();
    System.out.println("Length of the string is: " + function.apply("Hello"));
    
    function = (value)-> value.length();
    System.out.println("Length of the string is: " + function.apply("Hello"));
    
    //BiFunction using anonymous inner class
    BiFunction<Integer, String, String> biFunction = new BiFunction<Integer, String, String> () {
      @Override
      public String apply(Integer id, String name) {
        return id + " - " + name;
      }
    };
    
    System.out.println(biFunction.apply(101, "Imran Khan"));
    
    //BiFunction using lambda expression
    biFunction = (id, string) -> id + " - " + string;
    
    System.out.println(biFunction.apply(101, "Imran Khan"));
  }
}
