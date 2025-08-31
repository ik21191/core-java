package com.mypack;

import org.apache.log4j.Logger;

public class StaticMethodCallUsingInstanceVariable {
  private static final Logger log = Logger.getLogger(StaticMethodCallUsingInstanceVariable.class);
  private static int count = 100;

  public static void main(String[] args) {

    StaticMethodCallUsingInstanceVariable staticAndInstance = null;
    /**
     * The NullPointerException will not thrown by below statement, because the compiler converts below instance level
     * to class level call because the count is static field in the class.
     * */
    System.out.println(staticAndInstance.count);
    staticAndInstance.count = 200;
    log.info(StaticMethodCallUsingInstanceVariable.count);
  }

}
