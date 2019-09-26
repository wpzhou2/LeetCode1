package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/25  23:12
 * @Description:
 **/
public class LC_213_HouseRobber2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1) return nums[0];

        int len = nums.length;

        // ͵��һ�����ӣ���͵���һ�����ӣ�����Χ��1~n-1
        int[] dp1 = new int[len+1];
        dp1[1] = nums[0];
        dp1[2] = Math.max(nums[0], nums[1]);


        // ͵���һ�����ӣ���͵��һ�����ӣ�����Χ��2~n
        int[] dp2 = new int[len+1];
        dp2[2] = nums[1];


        for(int i = 3; i <= nums.length; i++){
            dp1[i] = Math.max(nums[i-1]+dp1[i-2], dp1[i-1]);
            dp2[i] = Math.max(nums[i-1]+dp2[i-2], dp2[i-1]);
        }

        return Math.max(dp1[len-1], dp2[len]);
    }
}
