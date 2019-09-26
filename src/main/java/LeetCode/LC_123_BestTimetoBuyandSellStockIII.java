package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/7  21:25
 * @Description:
 **/
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time
(i.e., you must sell the stock before you buy again).


Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
* */
public class LC_123_BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[][][] mp = new int[prices.length][3][2];
        /*
           三维数组：mp[i][j][k]
        *  i:第i天
        *  j:之前买卖了多少次
        *  k:0：持0股；1：持1股
        * */
        mp[0][0][0] = 0;//第一天，没有买卖，持0股，收益为0
        mp[0][0][1] = -prices[0];
        mp[0][1][0] = -10000;
        mp[0][1][1] = -10000;
        mp[0][2][0] = -10000;
        mp[0][2][1] = -10000;

        for (int i = 1; i < prices.length; i++) {
            mp[i][0][0] = mp[i - 1][0][0];
            mp[i][0][1] = Math.max(mp[i - 1][0][1], mp[i - 1][0][0] - prices[i]);

            mp[i][1][0] = Math.max(mp[i - 1][1][0], mp[i - 1][0][1] + prices[i]);
            mp[i][1][1] = Math.max(mp[i - 1][1][1], mp[i - 1][1][0] - prices[i]);

            mp[i][2][0] = Math.max(mp[i - 1][2][0], mp[i - 1][1][1] + prices[i]);
        }

        int end = prices.length - 1;
        int res = Math.max(Math.max(mp[end][0][0], mp[end][1][0]), mp[end][2][0]);
        return res;
    }
}
