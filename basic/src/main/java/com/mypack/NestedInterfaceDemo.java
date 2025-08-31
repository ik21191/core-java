package com.mypack;

interface A1 {
  void a1();
  
  interface B {
    void display();
  }
}

class A1Implementation implements A1 {
  @Override
  public void a1() {
    System.out.println("a1() of A1 is called.");    
  }
}

class BImplementation implements A1.B {
  @Override
  public void display() {
    System.out.println("display() fo A.B inner interface.");
  }
}
public class NestedInterfaceDemo  {
  
  public static void main(String arr[]) {
    A1 a1 = new A1Implementation();
    a1.a1();
    
    A1.B b = new BImplementation();
    b.display();
  }
}
