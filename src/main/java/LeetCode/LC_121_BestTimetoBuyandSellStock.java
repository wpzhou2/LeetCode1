package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/7  13:35
 * @Description:
 **/
/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction
(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
* */
public class LC_121_BestTimetoBuyandSellStock {

    //普通方法：使用当天的股票的价钱减去前面最低价格
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int res = 0;//最终最大收益结果
        int min = prices[0];//记录当前元素前面的最小价格
        int cur = prices[0];//记录卖出当前元素的股票收益

        for (int i = 1; i < prices.length; i++) {
            cur = prices[i] - min;//卖出当前元素的股票收益
            if (prices[i] < min) {
                min = prices[i];
            }
            if (cur > res) {
                res = cur;
            }
        }

        return res;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0;
        int[][] profit = new int[prices.length][3];
        //profit[i][0]:i+1天没有交易的最大收益(一直没有交易)
        //profit[i][1]:i+1天拥有一股股票还没卖的最大收益
        //profit[i][2]:i+1天拥有一股股票现在卖的最大收益
        profit[0][0] = 0;
        profit[0][1] = -prices[0];
        profit[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = profit[i - 1][0];
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
            profit[i][2] = Math.max(profit[i - 1][2], profit[i - 1][1] + prices[i]);
            res = Math.max(Math.max(res, profit[i][0]), Math.max(profit[i][1], profit[i][2]));
        }

        return res;
    }
}
