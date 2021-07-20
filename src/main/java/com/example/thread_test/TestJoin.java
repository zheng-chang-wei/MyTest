package com.example.thread_test;

public class TestJoin {

  public static void main(String[] args) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " start");
    Thread t1 = new Thread(new MyThread("A"));
    Thread t2 = new Thread(new MyThread("B"));
    Thread t3 = new Thread(new MyThread("C"));
    System.out.println("t1start");
    t1.start();
    System.out.println("t1end");
    System.out.println("t2start");
    t2.start();
    System.out.println("t2end");
    t1.join();
    System.out.println("t3start");
    t3.start();
    System.out.println("t3end");
    System.out.println(Thread.currentThread().getName() + " end");
  }
}
