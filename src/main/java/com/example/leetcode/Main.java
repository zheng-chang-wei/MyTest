package com.example.leetcode;

public class Main {
 
    public static void main(String[] args) {
        int num = 4;
        int[][] huiXingShu = new int[num][num];
 
        int count = 0; // 要显示的数据
        int maxX = num - 1; // x横轴的最大下标
        int maxY = num - 1; // Y纵轴的最大下标
        int minX = 0; // x横轴的最小下标
        int minY = 0; // Y纵轴的最小下标
        while (minX <= maxX) {  //直到X横轴线最小下标比最大下标还大时就退出循环 说明已经把值赋到最后一个了
            for (int x = minX; x <= maxX; x++) {    //向右 从最小到最大下标递增
                huiXingShu[minY][x] = ++count;  //必须++count 不然count++第一次会赋值为0
            }
            minY++;     //说明Y纵轴的最小下标+1 向右已经赋值完一行了
            for (int y = minY; y <= maxY; y++) {    //向下 从最小到最大下标递增
                huiXingShu[y][maxX] = ++count;
            }
            maxX--;     //以上同理不再赘述
            for (int x = maxX; x >= minX; x--) {    //向左 从最小到最大下标递减
                huiXingShu[maxY][x] = ++count;
            }
            maxY--;
            for (int y = maxY; y >= minY; y--) {    //向上 从最小到最大下标递减
                huiXingShu[y][minX] = ++count;
            }
            minX++;
        }
 
        // 遍历
        for (int[] anhuiXingShu : huiXingShu) {
            for (int anAnhuiXingShu : anhuiXingShu) {
                System.out.print(anAnhuiXingShu + "\t");
            }
            System.out.println();
        }
    }
}