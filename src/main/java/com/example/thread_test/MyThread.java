package com.example.thread_test;

/**
 * @author changwei.zheng
 * @date 2021/1/11 16:04
 * @describe
 */
public class MyThread implements Runnable {
  private String name;

  public MyThread(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 5; i++) {
      System.out.println(name + "-" + i);
    }
  }
}
