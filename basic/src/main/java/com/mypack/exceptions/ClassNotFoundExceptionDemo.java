package com.mypack.exceptions;

public class ClassNotFoundExceptionDemo {
  public void display() {
    System.out.println("display() of ClassNotFoundExceptionDemo.");
  }

  public static void main(String[] args) {
    System.out.println("hello");
    
    try {
      //If you remove package name, then JVM will not able to load the class and it will throw ClassNofFoundException
      Class<?> a = Class.forName("com.mypack.exceptions.ClassNotFoundExceptionDemo");
      /**Below method call is deprecated since Java9
       * ClassNotFoundExceptionDemo object = (ClassNotFoundExceptionDemo) a.newInstance();
       * */
      ClassNotFoundExceptionDemo object = (ClassNotFoundExceptionDemo) a.getDeclaredConstructor().newInstance();
      object.display();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}