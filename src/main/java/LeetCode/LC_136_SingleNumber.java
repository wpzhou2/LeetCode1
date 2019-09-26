package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  11:46
 * @Description:
 **/
public class LC_136_SingleNumber {
    public int singleNumber(int[] nums) {
        int a = nums[0];
        for(int i=1;i<nums.length;i++) {
            a=a^nums[i];
        }
        return a;
    }
}
