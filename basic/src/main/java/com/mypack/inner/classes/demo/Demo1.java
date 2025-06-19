package com.mypack.inner.classes.demo;

import com.mypack.inner.classes.nested.Outer;

public class Demo1 {

  public static void main(String[] args) {
    Outer.PublicInner inner = new Outer().new PublicInner();
    Outer.PublicStaticInner staticInner = new Outer.PublicStaticInner();
  }
}
