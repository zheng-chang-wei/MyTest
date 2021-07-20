package com.example.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

  public static Object u = new Object();
  static ChangeObjectThread t1 = new ChangeObjectThread("t1");
  static ChangeObjectThread t2 = new ChangeObjectThread("t2");

  public static class ChangeObjectThread extends Thread {
    public ChangeObjectThread(String name) {
      super(name);
    }

    @Override
    public void run() {
      synchronized (u) {
        System.out.println("in " + getName());
        LockSupport.parkUntil(9999999000000000L);
        if (Thread.currentThread().isInterrupted()) {
          System.out.println(getName() + "被中断了");
        }
        System.out.println(getName() + "继续执行");
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    t1.start();
    Thread.sleep(1000L);
    t2.start();
    //            t1.interrupt();

    LockSupport.unpark(t2);
    t1.join();
    t2.join();
    System.out.println(33);
  }
}
