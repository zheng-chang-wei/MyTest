package com.example.leetcode;

/**
 * @author zcw
 * @date 2021/05/12
 * <p>
 * Description:
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *  
 * 示例 1:
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股
 **/
public class 买卖股票的最佳时机2 {

    public static void main(String[] args) {
        int[] prices = {7, 2, 5, 1, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i + 1] > prices[i]) {
                count += prices[i + 1] - prices[i];
            }
        }
        return count;
    }
}
