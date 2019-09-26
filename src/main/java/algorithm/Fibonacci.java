package algorithm;

/**
 * @Author: weipeng
 * @Date: 2019/5/31  11:31
 * @Description:
 **/
public class Fibonacci {
    //递归代码
    int fib1(int N)
    {
        if (N == 0 || N == 1)
            return N;
        return fib1(N - 1) + fib1(N - 2);
    }

    //动态规划
    int fib(int N)
    {
        if (N < 2)
            return N;
        int result[] = new int[10000];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= N; i++)
        {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[N];
    }

}
