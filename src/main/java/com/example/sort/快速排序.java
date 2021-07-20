package com.example.sort;

public class 快速排序 {

    public static void main(String[] args) {
        int[] arrs = {9, 4, 8, 3,5};
        quickSort1(arrs);
        for (int i : arrs) {
            System.out.print(i + " ");
        }
    }

   private static void quickSort1(int[] arrs){
        if (arrs!=null&&arrs.length>0){
            quickSort1(arrs,0,arrs.length-1);
        }
   }

    private static void quickSort1(int[] arrs, int low, int high) {
       if (low<high){
           int mid=getMid3(arrs,low,high);
           quickSort1(arrs,low,mid-1);
           quickSort1(arrs,mid+1,high);
       }
    }

  private static int getMid3(int[] arrs, int low, int high) {
    int temp = arrs[low];
    while (low < high) {
      while (low < high && arrs[high] >= temp) {
        high--;
      }
      arrs[low] = arrs[high];
      while (low < high && arrs[low] <= temp) {
        low++;
      }
      arrs[high] = arrs[low];
    }
    arrs[low] = temp;
    return low;
  }

    private static int getMid(int[] arr, int low, int high) {

        //temp就是基准位
        int temp = arr[low];
        int r = high;
        int l=low;
        while (l < r) {
            //先看右边，依次往左递减
            while (temp < arr[r] && l < r) {
                r--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[l] && l < r) {
                l++;
            }
            //如果满足条件则交换
            if (l<r){
                int t = arr[r];
                arr[r] = arr[l];
                arr[l] = t;
                System.out.println();
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        temp=arr[r];
        arr[r]=arr[low];
        arr[low]=temp;
        return l;
    }


    private static int getMid2(int[] arrs, int low, int high) {
        int temp = arrs[low];
        while (low < high) {
            while (low < high && arrs[high] > temp) {
                high--;
            }
            arrs[low] = arrs[high];
            while (low < high && arrs[low] <= temp) {
                low++;
            }
            arrs[high] = arrs[low];
        }
        arrs[low] = temp;
        return low;
    }

    private static void quickSort(int[] arrs) {
        quickSort(arrs, 0, arrs.length - 1);
    }

    private static void quickSort(int[] arrs, int low, int high) {
        if (low < high) {
            int mid = getMid(arrs, low, high);
            quickSort(arrs, low, mid - 1);
            quickSort(arrs, mid + 1, high);
        }

    }
}
