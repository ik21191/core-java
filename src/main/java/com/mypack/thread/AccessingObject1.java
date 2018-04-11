package com.mypack.thread;

import org.apache.log4j.Logger;

public class AccessingObject1 implements Runnable {
	Logger log = Logger.getLogger(AccessingObject1.class);
	
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
        Thread.currentThread().join();
    }
}
