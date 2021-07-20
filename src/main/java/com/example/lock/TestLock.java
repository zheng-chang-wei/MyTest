package com.example.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author changwei.zheng
 * @date 2020/7/2 16:54
 * @describe
 */
public class TestLock {
  static ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {

    new Thread(
            () -> {
              m1();
            },
            "t1")
        .start();
    new Thread(
            () -> {
              m1();
            },
            "t2")
        .start();
  }

  public static synchronized void m1() {
    while (true) {
      System.out.println(Thread.currentThread().getName() + "  m1");
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    //    m2();
  }

  public static void m2() {

    try {
      lock.lock();
      lock.lockInterruptibly();
      System.out.println(Thread.currentThread().getName() + "  m2");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}
