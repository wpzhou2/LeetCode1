package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/26  15:55
 * @Description:
 **/
public class LC_46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        recursion(nums, 0, list);
        return list;
    }

    public void recursion(int[] nums,int start,List<List<Integer>> list){
        if(nums.length-start<=1){
            List<Integer> res = new ArrayList<Integer>();
            for(int n:nums){
                res.add(n);
            }
            if(!list.contains(res))
                list.add(res);
            return;
        }
        // 把后面的数组元素交换到start位置,并对start+1剩下的元素进行全排列
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            recursion(nums, start+1, list);
            swap(nums,start,i);
        }
    }

    void swap(int[] nums,int start,int i){
        int t = nums[start];
        nums[start] = nums[i];
        nums[i] = t;
    }


}
