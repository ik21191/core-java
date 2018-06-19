package com.mypack;
import org.apache.log4j.Logger;

import com.mypack.TestJar;

/**
 * clone project https://github.com/ik21191/testJar.git using git bash eg. git clone https://github.com/ik21191/testJar.git
 * build the project mvn clean package
 * add testJar.jar to this project using build path
 * This project was created to demonstrate the use of slf4j
 * */
public class Test1 {
	private static final Logger log = Logger.getLogger(Test1.class);
    public static void main(String[] args) {
       
        //log.info(TestJar.testMethod());
    	//This is conflict check
    	//This is navi changes
    }
}
