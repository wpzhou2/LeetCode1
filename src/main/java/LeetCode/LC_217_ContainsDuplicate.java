package LeetCode;

import java.util.HashSet;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  0:11
 * @Description:
 **/
public class LC_217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.add(num) == false){
                return true;
            }
        }
        return false;
    }
}
