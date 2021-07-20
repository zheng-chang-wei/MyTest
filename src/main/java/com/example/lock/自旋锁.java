package com.example.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author changwei.zheng
 * @date 2020/7/2 17:21
 * @describe
 */
public class 自旋锁 {
  AtomicReference<Thread> atomicReference = new AtomicReference<>();

  public static void main(String[] args) throws InterruptedException {
      自旋锁 test = new 自旋锁();
      new Thread(()->{
          test.myLock();
          try {
              TimeUnit.SECONDS.sleep(5);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          test.myUnLock();
      },"t1").start();
      TimeUnit.SECONDS.sleep(1);
      new Thread(()->{
          test.myLock();
          test.myUnLock();
      },"t2").start();
  }

  public void myLock() {
    Thread thread = Thread.currentThread();
    System.out.println(Thread.currentThread().getName() + "\t come in");
    while (!atomicReference.compareAndSet(null, thread)){}
  }

  public void myUnLock() {
      Thread thread = Thread.currentThread();
      atomicReference.compareAndSet(thread,null);
      System.out.println(Thread.currentThread().getName() + "\t come out");
  }
}
