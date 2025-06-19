package com.mypack.inner.classes.nested;

class X {

}

public class Outer {
  
  private X x = new X();
  private static X staticX = new X();

  //Public inner class, Can be accessed outside the package using
  /** Outer.PublicInner inner = new Outer().new PublicInner(); **/
  //Reference com.mypack.inner.classes.demo.Demo1
  public class PublicInner {
    public void innerDisplay() {
      // Inner class can access private member of Outer class
      System.out.println("Accessing private member of Outer class: " + x);
    }
  }
  
  //Can be accessed within the same package using
  /** Outer.DefaultInner defaultInner = new Outer().new DefaultInner(); **/
  class DefaultInner {
    public void innerDisplay() {
      // Inner class can access private member of Outer class
      System.out.println("Accessing private member of Outer class: " + x);
    }
  }

  //Public static inner class, Can be accessed outside the package using
  /** Outer.PublicStaticInner staticInner = new Outer.PublicStaticInner(); **/
  public static class PublicStaticInner {
    public void dislay() {
     // Static inner class can access private static member of Outer class
      System.out.println(staticX);
    }

    public static void print() {
      System.out.println("print() of StaticInner");
    }
  }
  //Can be accessed within the same package using
  /** Outer.DefaultStaticInner staticInner = new Outer.DefaultStaticInner(); **/
  static class DefaultStaticInner {
    public static void myStaticMethod() {
      
    }
  }

  public static void main(String[] args) {
    
    DefaultInner defaultInner = new Outer().new DefaultInner();
    defaultInner.innerDisplay();

    // creating instance of StaticInnerClass
    DefaultStaticInner defaultStaticInner = new DefaultStaticInner();
    System.out.println(defaultStaticInner);
  }
}
