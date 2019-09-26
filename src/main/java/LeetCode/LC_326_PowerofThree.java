package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  1:04
 * @Description:
 **/
public class LC_326_PowerofThree {
    public boolean isPowerOfThree(int n) {
        if(n==1)    return true;
        if(n%3!=0 || n<=0)  return false;
        return isPowerOfThree(n/3);
    }
}
