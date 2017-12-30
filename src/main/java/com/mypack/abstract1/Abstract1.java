package com.mypack.abstract1;

import org.apache.log4j.Logger;

public abstract class Abstract1 // A class can be abstract with or without abstract method
{
	Logger log = Logger.getLogger(Abstract1.class);
	public abstract void print();
    public void display() {
        log.info("display() in Absract1");
    }
    public static void main(String arr[]) {
        
    }
}
