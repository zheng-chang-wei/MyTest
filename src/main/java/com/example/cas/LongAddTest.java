package com.example.cas;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author changwei.zheng
 * @date 2020/12/1 10:06
 * @describe
 */
public class LongAddTest {
  public static void main(String[] args) {
      LongAdder longAdder = new LongAdder();
      longAdder.increment();
  }
}
