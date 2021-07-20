package com.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.*;

@Slf4j
public class ExecutorsTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    executor();
  }

  public static void executor() throws ExecutionException, InterruptedException {
    ThreadPoolExecutor executor =
        new ThreadPoolExecutor(2, 6, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
    int tempI = 0;
    System.out.println(executor.allowsCoreThreadTimeOut());
    executor.allowCoreThreadTimeOut(true);
    System.out.println(executor.getActiveCount());
    // Starts all core threads
    executor.prestartAllCoreThreads();
    // Starts a core thread
    executor.prestartCoreThread();
    System.out.println(executor.getActiveCount());
    TimeUnit.SECONDS.sleep(3);
    System.out.println(executor.getActiveCount());
    // maxPoolSize Integer.MAX_VALUE
    ExecutorService executorService = Executors.newCachedThreadPool();
    Executors.newScheduledThreadPool(3);
    // LinkedBlockingQueue
    Executors.newFixedThreadPool(3);
    Executors.newSingleThreadExecutor();
    Executors.newSingleThreadScheduledExecutor();
  }
}
