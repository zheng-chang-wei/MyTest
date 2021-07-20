package com.example.thread_test.common;

public class Work implements Runnable {

  private Thread thread;

  public Work() {}

  public Work(Thread thread) {
    this.thread = thread;
  }

  @Override
  public void run() {
    try {
      if (thread != null) {
        thread.join();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.print(Thread.currentThread().getName() + " ");
    if ("3".equals(Thread.currentThread().getName())) {
      System.out.println();
    }
  }
}
