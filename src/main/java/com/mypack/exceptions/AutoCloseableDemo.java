package com.mypack.exceptions;

import org.apache.log4j.Logger;

class MyAutoCloseable implements AutoCloseable {//We can only use Try-With-Resource if the class implements AutoCloseable
	private static final Logger log = Logger.getLogger(MyAutoCloseable.class);
	@Override
	public void close() throws Exception {
		log.info("close() method is called of MyAutocloseable");
	}
	
	public void display() {
		log.info("display() of MyAutocloseable is called."); 
	}
	
	public void displayWithException() throws NullPointerException{
		throw new NullPointerException();
	}
}

public class AutoCloseableDemo {
	private static final Logger log = Logger.getLogger(AutoCloseableDemo.class);
	public static void main(String[] args) {
		
		try(MyAutoCloseable myAutoCloseable = new MyAutoCloseable()) {
			myAutoCloseable.display();
			myAutoCloseable.displayWithException();
		} catch(NullPointerException e1) {
			log.error(e1);
		} catch(Exception e2) {
			log.error(e2);
		}
	}
}
