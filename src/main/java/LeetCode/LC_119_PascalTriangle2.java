package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  11:07
 * @Description:
 **/
public class LC_119_PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        List<Integer> prior = null;

        //从第0行开始算，返回第rowIndex行
        for(int i = 1; i <= rowIndex+1; i++) {
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
        return prior;
    }
}
