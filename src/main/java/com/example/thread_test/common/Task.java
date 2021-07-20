package com.example.thread_test.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Integer> {

  @Override
  public Integer call() throws Exception {
    System.out.println(1);
    TimeUnit.SECONDS.sleep(3);
    return 1024;
  }
}