package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  1:12
 * @Description:
 **/
public class LC_39_CombinationSum {
    List<List<Integer>> resList;
    int[] mycandidates;
    int mytarget;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        resList = new ArrayList<List<Integer>>();
        mycandidates = candidates;
        mytarget = target;
        Arrays.sort(mycandidates);

        getCombinationSum(0,0,new ArrayList<Integer>());
        return resList;
    }

    //��candidates��start��ʼ������Ϊtarget�Ľ����sum���浱ǰ�ĺͣ�list������ǵ�ǰ�Ѿ���ӵ�����
    public void getCombinationSum(int start, int sum, List<Integer> list){
        if(sum==mytarget){
            resList.add(new ArrayList<Integer>(list));
        }

        for (int i = start; i <mycandidates.length ; i++) {
            if(sum + mycandidates[i] <= mytarget){
                list.add(mycandidates[i]);
                getCombinationSum(i,sum+mycandidates[i],list);
                list.remove(list.size()-1);//����
            }else{
                return;
            }
        }
    }
}
