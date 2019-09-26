package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/13  15:57
 * @Description:
 **/
public class LC_416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int volumn = 0;
        for (int item : nums) {
            volumn += item;
        }

        if (volumn % 2 == 1) {
            return false;//和为奇数不可能满足要求
        }

        volumn /= 2;
        boolean dp[] = new boolean[volumn + 1];
        dp[0] = true;//初始条件
        for (int i = 1; i < nums.length; i++) {
            for (int j = volumn; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[volumn];
    }
}
