package LeetCode;

import java.util.HashMap;

/**
 * @Author: weipeng
 * @Date: 2019/5/4  1:12
 * @Description:
 **/

/*
*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


time:O(n)
space:O(n)

* */
public class LC_1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length < 2) {
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);//向map放入数值，位置
        }
        return res;
    }


}
