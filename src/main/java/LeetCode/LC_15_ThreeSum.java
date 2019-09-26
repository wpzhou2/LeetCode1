package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  1:01
 * @Description:
 **/
public class LC_15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);

        if (nums[0] <= 0 && nums[nums.length - 1] >= 0){
            for (int i = 0; i < nums.length - 2;) {
                if (nums[i] > 0) break;//最小数
                int l = i + 1;//第二大数的位置
                int r = nums.length - 1;//最大数的位置

                do {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0){
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    }
                    if (sum >= 0){
                        while (nums[r] == nums[--r] && r > l);
                    }else {
                        while (nums[l] == nums[++l] && r > l);
                    }
                }while (r > l);

                //如果i后面有重复数，消去
                while (nums[i] == nums[++i] && i < nums.length - 2);
            }
        }
        return res;
    }
}
