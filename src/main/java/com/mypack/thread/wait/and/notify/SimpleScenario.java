package com.mypack.thread.wait.and.notify;

import org.apache.log4j.Logger;

public class SimpleScenario {
	private static final Logger log = Logger.getLogger(SimpleScenario.class);
	
    public static void main(String[] args){
    	ThreadSum b = new ThreadSum();
        b.start();
 
        synchronized(b){
            try{
                log.info("Waiting for b to complete...");
                b.wait();// This call make the current thread in wait state unit thread b calls notify() method
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            log.info("Total is: " + b.total);
        }
    }
}
 
class ThreadSum extends Thread {
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<10 ; i++){
            	try {
					//Thread.sleep(1000); // if we comment this then we have no other thread to wake this, so it will wait infinitly 
				} catch (Exception e) {
					e.printStackTrace();
				}
                total += i;
            }
            notify();
        }
    }
}