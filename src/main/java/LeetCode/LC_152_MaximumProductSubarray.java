package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/7  11:25
 * @Description:
 **/
/*
Given an integer array nums, find the contiguous subarray within an array
(containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
* */
public class LC_152_MaximumProductSubarray {
    public int maximumProductSubarray(int[] nums) {
        //dp[i][0]:在i位置的乘积最大子序列的乘积
        //dp[i][1]:在i位置的乘积最小子序列的乘积
        int[][] dp = new int[nums.length][2];
        int res = nums[0];

        dp[0][0] = dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (nums[i] >= 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * num, num);
                dp[i][1] = Math.min(dp[i - 1][1] * num, num);
            } else {
                dp[i][0] = Math.max(dp[i - 1][1] * num, num);
                dp[i][1] = Math.min(dp[i - 1][0] * num, num);
            }
            if (dp[i][0] > res) {
                res = dp[i][0];
            }
        }

        return res;
    }

    public int maxProduct(int[] nums) {
        int curmax, curmin, res;
        curmax = curmin = res = nums[0];

        int num, max, min;

        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            max = curmax * num;
            min = curmin * num;

            curmax = Math.max(Math.max(max, min), num);
            curmin = Math.min(Math.min(max, min), num);

            if (curmax > res) {
                res = curmax;
            }
        }

        return res;
    }
}
