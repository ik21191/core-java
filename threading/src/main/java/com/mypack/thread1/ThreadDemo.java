package com.mypack.thread1;

class Counter {
  private int count = 0;

  public void  increment() {
    count++;
  }

  public int getCount() {
    System.out.println("Executing non syncronized statements...");
    synchronized (this) {
      return count;
    }
  }
}


class ThreadDemo extends Thread {
  Counter counter;

  ThreadDemo(Counter counter) {
    this.counter = counter;
  }

  public void run() {
    synchronized (counter) {
      for (int i = 0; i < 10; i++) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        counter.increment();
      }
    }
    
  }



  public static void main(String[] args) throws InterruptedException {
    Counter counter = new Counter();
    ThreadDemo t1 = new ThreadDemo(counter);
    ThreadDemo t2 = new ThreadDemo(counter);

    t1.start();
    //t2.start();

//    try {
//      t1.join();
//      t2.join();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
Thread.sleep(1000);
    System.out.println("Final count: " + counter.getCount());
  }
}
