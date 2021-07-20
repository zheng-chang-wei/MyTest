package com.example.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/** */
public class CyclicBarrierDemo {
  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {System.out.println("召唤神龙");});
    for (int i = 0; i < 7; i++) {
      final Integer tempInt = i;
      new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到 第" + tempInt + "颗龙珠");
                try {
                  // 先到的被阻塞，等全部线程完成后，才能执行方法
                  cyclicBarrier.await();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                } catch (BrokenBarrierException e) {
                  e.printStackTrace();
                }
              },String.valueOf(i))
          .start();
    }
  }
}
