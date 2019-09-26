package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  0:35
 * @Description:
 **/
public class LC_53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int sum=0;
        for(int num:nums){
            if(sum>0)   sum += num;
            else        sum = num;

            res = Math.max(res,sum);
        }
        return res;
    }
}
