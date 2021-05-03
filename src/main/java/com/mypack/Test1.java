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
       
        log.info(TestJar.testMethod());
    	
    	String value = "ahcabdef";
    	System.out.println(value.substring(0, 8));
    	System.out.println("length : " + value.length());
    	System.out.println("charAt\t" + value.charAt(1));
    	System.out.println("indexOf\t" + value.indexOf("ab"));
    	
    	int val1 = value.indexOf("ab");
    	int val2 = "ab".length();
    	//System.out.println("substring\t" + value.substring(value.indexOf("ab"), value.indexOf("ab") + "ab".length()));
    	System.out.println("start index : " + (val1 + val2));
    	System.out.println("substring\t" + value.substring(value.indexOf("ab") + "ab".length(), value.length()-1));
    	
    	
    }
}
