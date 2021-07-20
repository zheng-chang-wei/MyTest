package com.example.leetcode;

/**
 * @author zcw @Description:
 * @date 2021-07-1921:44
 */
public class 回形数 {
  public static void main(String[] args) {
    int[][] results = circleNum(4);
    for (int[] result : results) {
      for (int i : result) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
    System.out.println(results[0][1]);
  }

  public static int[][] circleNum(int num) {
    int[][] huiXingShu = new int[num][num];
    int value = 0;
    int minI = 0;
    int minJ = 0;
    int maxI = num - 1;
    int maxJ = num - 1;
    while (minI <= maxI) {
      for (int i = minJ; i <= maxJ; i++) {
        huiXingShu[minI][i] = ++value;
      }
      minI++;
      for (int i = minI; i <= maxI; i++) {
        huiXingShu[i][maxJ] = ++value;
      }
      maxJ--;
      for (int i = maxJ; i >= minJ; i--) {
        huiXingShu[maxI][i] = ++value;
      }
      maxI--;
      for (int y = maxI; y >= minI; y--) { // 向上 从最小到最大下标递减
        huiXingShu[y][minJ] = ++value;
      }
      minJ++;
    }
    return huiXingShu;
  }
}
