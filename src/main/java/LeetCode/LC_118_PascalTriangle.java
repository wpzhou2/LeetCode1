package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  0:48
 * @Description:
 **/
public class LC_118_PascalTriangle {

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        List<Integer> prior = null;

        for(int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>(i);
            for(int j = 0; j < i; j++) {
                if(j == 0 || j == i - 1) {
                    temp.add(1);
                } else {
                    temp.add(prior.get(j - 1) + prior.get(j));
                }
            }
            nums.add(temp);
            prior = temp;
        }

        return nums;
    }
}
