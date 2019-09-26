package LeetCode;

import java.util.Arrays;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  12:27
 * @Description:
 **/
public class LC_16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int threeSum = nums[i]+nums[l]+nums[r];
                if(Math.abs(threeSum-target)<Math.abs(res-target)){
                    res = threeSum;
                }
                if(threeSum<target){
                    l++;
                }
                else if(threeSum>target){
                    r--;
                }
                else{
                    return threeSum;
                }
            }
        }
        return res;
    }
}
