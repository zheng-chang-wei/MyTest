package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author changwei.zheng
 * @date 2020/12/3 14:12
 * @describe
 */
public class 计数质数 {
  public static void main(String[] args) {
    //    System.out.println(Math.sqrt(4)==2);
    计数质数 main = new 计数质数();
    System.out.println(main.countPrimes3(499979));
  }

  public int countPrimes(int n) {
    List<Integer> primes = new ArrayList<Integer>();
    int[] isPrime = new int[n];
    Arrays.fill(isPrime, 1);
    for (int i = 2; i < n; ++i) {
      if (isPrime[i] == 1) {
        primes.add(i);
      }
      for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
        isPrime[i * primes.get(j)] = 0;
        if (i % primes.get(j) == 0) {
          break;
        }
      }
    }
    return primes.size();
  }

  public int countPrimes3(int n) {
    boolean[] isPrime = new boolean[n];
    int count = 0;
    for (int i = 2; i < n; ++i) {
      if (!isPrime[i]) {
        count++;
      }
      int a = 0;
      for (int j = i + i; j < n; j += i) {
        isPrime[j] = true;
      }
    }
    return count;
  }

  public int countPrimes2(int n) {
    int count = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 2; i < n; i++) {
      if (isPrimeNumber(list, i)) {
        count++;
        list.add(i);
        System.out.println(i);
      }
    }
    return count;
  }

  private boolean isPrimeNumber(List<Integer> list, int i) {
    for (Integer prime : list) {
      if (i % prime == 0) {
        return false;
      }
    }
    return true;
  }
}
