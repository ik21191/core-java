package com.mypack.inerfaces;

interface X1 {
  void display();
}


interface X2 {
  void display();
}


interface X3 extends X1, X2 {
  @Override
  void display();
}


public interface A {
  public ImplementorA getImplementorA();
}

