package com.mypack;
import org.apache.log4j.Logger;

import com.mypack.TestJar;


public class Test1 {
	private static final Logger log = Logger.getLogger(Test1.class);
    public static void main(String[] args) {
       
        log.info(TestJar.testMethod());
    }
}
