package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  22:11
 * @Description:
 **/
public class LC_376_WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if(length<2){
            return length;
        }
        int up = 1;
        int down = 1;
        for(int i=1;i<length;i++){
            if(nums[i]>nums[i-1]){
                up = down+1;
            }
            if(nums[i]<nums[i-1]){
                down = up+1;
            }
        }
        return Math.max(up, down);
    }
}
