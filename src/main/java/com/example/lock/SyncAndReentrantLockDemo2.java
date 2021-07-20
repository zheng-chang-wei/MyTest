package com.example.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized 和 Lock的区别
 *
 * @author: 陌溪
 * @create: 2020-03-17-10:18
 */
class ShareResource2 {
  // A 1   B 2   c 3
  private volatile int number = 1;
  private Lock lock = new ReentrantLock();

  private Condition condition1 = lock.newCondition();
  private Condition condition2 = lock.newCondition();
  private Condition condition3 = lock.newCondition();

  public void print5() {
    lock.lock();
    try {
      while (number != 1) {
        System.out.println("condition1.await()");
        condition1.await();
      }
      for (int i = 0; i < 5; i++) {
        System.out.print(Thread.currentThread().getName());
      }
      System.out.println();
      number = 2;
      condition2.signal();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void print10() {
    lock.lock();
    try {
      while (number != 2) {
        System.out.println("condition2.await()");
        condition2.await();
      }
      for (int i = 0; i < 10; i++) {
        System.out.print(Thread.currentThread().getName());
      }
      System.out.println();
      number = 3;
      condition3.signal();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void print15() {
    lock.lock();
    try {
      while (number != 3) {
        System.out.println("condition3.await()");
        condition3.await();
      }
      for (int i = 0; i < 15; i++) {
        System.out.print(Thread.currentThread().getName());
      }
      System.out.println();
      number = 1;
      condition1.signal();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}

public class SyncAndReentrantLockDemo2 {

  public static void main(String[] args) {

    ShareResource2 shareResource = new ShareResource2();

    new Thread(
            () -> {
              for (int i = 0; i < 2; i++) {
                shareResource.print5();
                try {
                  TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            },
            "A")
        .start();

    new Thread(
            () -> {
              for (int i = 0; i < 2; i++) {
                shareResource.print10();
              }
            },
            "B")
        .start();

    new Thread(
            () -> {
              for (int i = 0; i < 2; i++) {
                shareResource.print15();
              }
            },
            "C")
        .start();
  }
}
