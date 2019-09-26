package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/14  16:07
 * @Description:
 **/
public class LC_322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        //dp[i]:��ʾ�ճ�iԪ�����ٸ�Ӳ�ҵĸ���
        //dp[0]��ʾ�ճ�0Ԫ������Ҫ0��Ӳ��
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            int t;
            for (int j = 0; j < coins.length; j++) {
                if (i > coins[j]) {
                    t = dp[i - coins[j]];
                    if (t < min) {
                        min = t;
                    }
                }
            }
            dp[i] = min + 1;
        }

        if (dp[amount] > amount)
            return -1;
        else return dp[amount];
    }
}
