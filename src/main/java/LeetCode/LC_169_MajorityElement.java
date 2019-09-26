package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: weipeng
 * @Date: 2019/5/10  19:28
 * @Description:
 **/
public class LC_169_MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }
        int res = 0;
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > count) {
                count = map.get(key);
                res = key;
            }
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count = 1;
            }
            if (nums[i] == num) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}
