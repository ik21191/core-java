package com.mypack;

import org.apache.log4j.Logger;

public class Numeric1 {
  private static final Logger log = Logger.getLogger(Numeric1.class);

  public static void main(String arr[]) {
    double d = 30;
    log.info(d);

    double i = 31.0 / 2;
    log.info(i);

    double j = 31 / 2;
    log.info(j);
  }
}
