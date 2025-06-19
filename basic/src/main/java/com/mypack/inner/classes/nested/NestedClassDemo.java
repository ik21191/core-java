package com.mypack.inner.classes.nested;


public class NestedClassDemo {

  public static void main(String[] args) {
    Outer.DefaultInner defaultInner = new Outer().new DefaultInner();
    Outer.DefaultStaticInner staticInner = new Outer.DefaultStaticInner();
    Outer.DefaultStaticInner.myStaticMethod();
  }
}
