package LeetCode;

import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/7  0:31
 * @Description:
 **/
/*
Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
* */

/*
 * 使用动态规划解决
 * */
public class LC_120_Triangle {
    public static int triangle(List<List<Integer>> triangle) {
        //记录每一层的最优结果
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + list.get(j);
            }
        }
        return dp[0][0];
    }
}
