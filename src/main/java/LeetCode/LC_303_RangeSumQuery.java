package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  22:07
 * @Description:
 **/
public class LC_303_RangeSumQuery {
    int sum[];

    public void NumArray(int[] nums) {
        if(nums.length == 0){
            return;
        }
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0){
            return sum[j];
        }
        return sum[j] - sum[i-1];
    }
}
