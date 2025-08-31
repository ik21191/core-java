package com.mypack;

import org.apache.log4j.Logger;

/***
 * A class can be abstract with or without abstract method
 */
public abstract class AbstractClassDemo {
  Logger log = Logger.getLogger(AbstractClassDemo.class);

  public abstract void print();

  public void display() {
    log.info("display() in AbstractClassDemo");
  }

  public static void main(String arr[]) {
    /***
     * we can't create instance of Abstract class that is why creating annonymous inner class
     */
    AbstractClassDemo abstract1 = new AbstractClassDemo() {
      @Override
      public void print() {
        log.info("this is print");

      }
    };
    abstract1.print();
    abstract1.display();
  }
}
