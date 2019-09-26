package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/10  16:22
 * @Description:
 **/
public class LC_50_Pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 0) {
            //nÎªÅ¼Êý
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x, n - 1);
        }
    }

    public double myPow1(double x, int n) {
//        double res = 1.0;
//        for(int i = n; i != 0; i /= 2){
//            if(i % 2 != 0){
//                res *= x;
//            }
//            x *= x;
//        }
//        return  n < 0 ? 1 / res : res;
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 == 1) {
                //ÆæÊý
                res = res * x;
            }
            x = x * x;
        }
        return n < 0 ? 1 / res : res;
    }
}
