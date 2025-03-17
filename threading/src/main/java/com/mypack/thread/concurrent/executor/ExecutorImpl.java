package com.mypack.thread.concurrent.executor;

import java.util.concurrent.Executor;

public class ExecutorImpl implements Executor {

  @Override
  public void execute(Runnable command) {
    new Thread(command, "Thread1").start();
  }

  public static void main(String[] args) {

    ExecutorImpl executorImpl = new ExecutorImpl();
    executorImpl.execute(() -> {
      System.out.println(Thread.currentThread().getName() + " : executing run method");
    });
  }
}
