package com.mypack.thread.misc;

import org.apache.log4j.Logger;

class SynchronizedObject1 {
	private int count = 0;

	public synchronized void increment() {
		count++;
	}

	public synchronized void decrement() {
		count--;
	}

	public int display() {
		return count;
	}
}

public class AccessingObject1 implements Runnable {
	private static Logger log = Logger.getLogger(AccessingObject1.class);
	
    SynchronizedObject1 syn = new SynchronizedObject1();
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            syn.increment();
            try{Thread.sleep(2000);
            }catch(Exception e){
                log.error(e);
            }
            log.info("Thread name : " + Thread.currentThread().getName() + "    " + syn.display());
        }
    }
    public static void main(String arr[])throws Exception {
        Thread t1 = new Thread(new AccessingObject1(), " Thread_1");
        Thread t2 = new Thread(new AccessingObject1(), " Thread_2");
        t1.start();
        t2.start();
        log.info("completed.");
    }
}
