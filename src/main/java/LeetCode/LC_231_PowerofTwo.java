package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  11:56
 * @Description:
 **/
public class LC_231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n==1)    return true;
        if(n%2 != 0 || n<1)    return false;
        return isPowerOfTwo(n/2);
    }
}
