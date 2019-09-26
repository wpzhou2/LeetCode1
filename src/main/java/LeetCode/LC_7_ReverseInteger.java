package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  10:35
 * @Description:
 **/
public class LC_7_ReverseInteger {
    public int reverse(int x) {
        long res = reverseX(x);
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;
    }

    long reverseX(int x){
        long res = 0;
        while (x != 0) {
            int t = x % 10;
            res = res * 10 + t;
            x = x / 10;
        }
        return res;
    }
}
