package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/14  20:39
 * @Description:
 **/
public class LC_72_EditDistance {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int dp[][] = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }

        int t;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                t = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                if (word1.charAt(i) == word2.charAt(j)) {
                    t = Math.min(dp[i - 1][j - 1], t);
                }
                dp[i][j] = t;
            }
        }
        return dp[l1][l2];
    }
}
