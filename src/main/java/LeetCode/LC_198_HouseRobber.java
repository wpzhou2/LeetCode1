package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/25  20:40
 * @Description:
 **/
public class LC_198_HouseRobber {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1) return nums[0];

        nums[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            nums[i] = Math.max(nums[i]+nums[i-2],nums[i-1]);
        }
        return nums[nums.length-1];
    }


}


