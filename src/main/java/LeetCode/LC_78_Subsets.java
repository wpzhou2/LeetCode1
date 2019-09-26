package LeetCode;

import java.util.*;

/**
 * @Author: weipeng
 * @Date: 2019/5/26  22:27
 * @Description:
 **/
public class LC_78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> levelList = new ArrayList<Integer>();
        result.add(new ArrayList<Integer>(levelList));
        subsetsDFS(result, levelList, 0, nums);
        return result;
    }

    private void subsetsDFS(List<List<Integer>> result, List<Integer> levelList, int index, int[] nums) {
        for (int i = index; i < nums.length; i++) {
            levelList.add(nums[i]);
            result.add(new ArrayList<Integer>(levelList));
            subsetsDFS(result, levelList, i + 1, nums);
            levelList.remove(levelList.size() - 1);
        }
    }




    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }

        res.add(new ArrayList<Integer>());

        for(int i=0; i < nums.length; i++){
            int size = res.size();
            for(int j = 0; j < size; j++){
                List<Integer> list = res.get(j);
                List<Integer> tmpList = new ArrayList<Integer>(list);
                tmpList.add(nums[i]);
                res.add(tmpList);
            }
        }
        return res;
    }
}
