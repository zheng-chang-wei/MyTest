package com.example.thread_test;

import java.util.concurrent.TimeUnit;

/**
 * @author changwei.zheng
 * @date 2021/1/11 11:34
 * @describe
 */
public class ThreadState {
  private Object lock1 = new Object();
  private Object lock2 = new Object();
  Thread.State state = Thread.State.NEW;

  public static void main(String[] args) {
    //
    ThreadState threadState = new ThreadState();

    //    threadState.test_Runnable();
    //    threadState.test_Timed_Waiting();
    //    threadState.test_Waiting();
    //    threadState.test_Blocked();
    threadState.test_DeadLock();
  }

  public void test_Runnable() {
    //    new Thread(
    //            new Runnable() {
    //              @Override
    //              public void run() {
    //                int i = 0;
    //                while (true) {
    //                  System.out.println(i++);
    //                }
    //              }
    //            },
    //            "aaa")
    //        .start();
    new Thread(
            () -> {
              int i = 0;
              while (true) {
                sout();
                System.out.println(i++);
              }
            },
            "aaa")
        .start();
  }

  public void test_Timed_Waiting() {
    new Thread(
            () -> {
              try {
                TimeUnit.SECONDS.sleep(200);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            },
            "aaa")
        .start();
  }

  public void test_Waiting() {
    new Thread(
            () -> {
              synchronized (lock1) {
                sleep(20);
                //                int i = 0;
                //                while (true) {
                //                  System.out.println(i++);
                //                }
              }
            },
            "aaa")
        .start();
    sleep(1);
    new Thread(
            () -> {
              synchronized (lock1) {
                sleep(30);
                System.out.println(Thread.currentThread().getState());
                lock1.notify();
              }
            },
            "bbb")
        .start();
  }

  public void test_Blocked() {
    new Thread(
            () -> {
              synchronized (lock1) {
                int i = 0;
                while (true) {
                  System.out.println(i++);
                }
              }
            },
            "aaa")
        .start();
    sleep(1);

    new Thread(
            () -> {
              synchronized (lock1) {
                sleep(30);
              }
            },
            "bbb")
        .start();
  }

  public void test_DeadLock() {
    new Thread(
            () -> {
              synchronized (lock1) {
                sleep(1);
                synchronized (lock2) {
                  int i = 0;
                  while (true) {
                    System.out.println(i++);
                  }
                }
              }
            },
            "aaa")
        .start();

    new Thread(
            () -> {
              synchronized (lock2) {
                sleep(1);
                synchronized (lock1) {
                  int i = 0;
                  while (true) {
                    System.out.println(i++);
                  }
                }
              }
            },
            "bbb")
        .start();
  }

  private void sleep(int seconds) {
    try {
      TimeUnit.SECONDS.sleep(seconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void sout() {
    Thread currentThread = Thread.currentThread();
    System.out.println("线程" + currentThread.getName() + "当前状态为：" + currentThread.getState());
  }
}
