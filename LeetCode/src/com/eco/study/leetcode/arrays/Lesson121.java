package com.eco.study.leetcode.arrays;

/**
 * @author 虫子
 * @date 2021-08-13 23:01:00
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 提示：
 *
 *     1 <= prices.length <= 105
 *     0 <= prices[i] <= 104
 */
public class Lesson121 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,4,3,1};
        Solution121 solution = new Solution121();
        System.out.println(solution.maxProfit(prices));
    }
}

class Solution121 {

    /**
     * 通过折线图可以看出,做大值减去最小值在就是最大利润
     * 则可以单次循环计算出 最大值 和 最小值
     * 时间效率与O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int min= Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if(min > prices[i]){
                min = prices[i];
            } else if (prices[i] - min > max){
                max  = prices[i] - min;
            }
        }
        return max;
    }

    /**
     * O(n2)。循环运行 n(n−1)2\{n (n-1)}{2},2n(n−1) 次。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices){
        int max = 0;
        int p;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                p = prices[j] - prices[i];
                if(max < p ){
                    max = p;
                }
            }
        }
        return max;
    }
}