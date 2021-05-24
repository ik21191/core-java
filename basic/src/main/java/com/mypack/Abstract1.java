package com.mypack;

import org.apache.log4j.Logger;

/***
 * A class can be abstract with or without abstract method
 */
public abstract class Abstract1 
{
	Logger log = Logger.getLogger(Abstract1.class);
	public abstract void print();
    public void display() {
        log.info("display() in Absract1");
    }
    public static void main(String arr[]) {
    	/***
    	 * we can't create instance of Abstract class that is why creating annonymous inner class
    	 */
    	Abstract1 abstract1 = new Abstract1() {
    		@Override
    		public void print() {
    			log.info("this is print");
    			
    		}
    	};
    	abstract1.print();
    	abstract1.display();
    }
}
