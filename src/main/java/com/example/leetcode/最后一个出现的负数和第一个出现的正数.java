package com.example.leetcode;

/**
 * @author zcw
 * @date 2021/06/29
 * <p>
 * Description:
 **/
public class 最后一个出现的负数和第一个出现的正数 {
    public static void main(String[] args) {
        int[] arrs = {-1, -1, 0, 0, 2, 3};
        int[] solution = solution(arrs);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arrs) {
        int[] results = new int[2];
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] == 0 && arrs[i - 1] != 0) {
                results[0] = arrs[0];
            }
            if (arrs[i] == 0 && arrs[i + 1] != 0) {
                results[1] = arrs[i + 1];
            }
        }
        return results;
    }
}
