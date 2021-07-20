package com.example.sort;

public class 二分查找 {

    public static void main(String[] args) {
        int[] arrs = {1, 2, 3, 4, 5,};
        int index = getIndex2(arrs, 5);
        System.out.println(index);

    }

    private static int getIndex2(int[] arrs, int n) {
        int low = 0;
        int high = arrs.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arrs[mid] == n) {
                return mid;
            }
            if (arrs[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * @param arrs
     * @param n
     * @return
     */

    private static int getIndex(int[] arrs, int n) {
        int low = 0;
        int high = arrs.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arrs[mid] == n) {
                return mid;
            }
            if (arrs[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
