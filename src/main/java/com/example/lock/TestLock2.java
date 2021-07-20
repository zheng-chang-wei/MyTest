package com.example.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author changwei.zheng
 * @date 2020/7/2 16:54
 * @describe
 */
public class TestLock2 {
  static int a, b, x, y = 0;
  private Object lock = new Object();

  public static void main(String[] args) {

    new TestLock2().test();
  }

  private void test() {
    try {
        synchronized (lock){
            System.out.println(1);
            lock.wait();
            System.out.println(2);
        }

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
