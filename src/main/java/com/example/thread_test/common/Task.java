package com.example.thread_test.common;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Integer> {
  FutureTask<Integer> futureTask;

  public Task() {}

  public Task(FutureTask<Integer> futureTask) {
    this.futureTask = futureTask;
  }

  @Override
  public Integer call() throws Exception {
    if (futureTask != null) {
      futureTask.get();
    }
    System.out.print(Thread.currentThread().getName() + " ");
    if ("3".equals(Thread.currentThread().getName())) {
      System.out.println();
    }
    return 1024;
  }
}
