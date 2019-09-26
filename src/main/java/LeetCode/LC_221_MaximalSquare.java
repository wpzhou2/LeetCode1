package LeetCode;

import java.util.Arrays;

/**
 * @Author: weipeng
 * @Date: 2019/5/25  22:20
 * @Description:
 **/
public class LC_221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null  || matrix.length == 0){
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;

        // the length of binary matrix which ends at i,j
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++)
            Arrays.fill(dp[i], 0);

        int max = 0;
        for (int i = 1; i < m+1; i++) {
            for (int j=1; j < n+1; j++) {
                if (matrix[i-1][j-1]== '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1], dp[i][j-1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max*max;

    }
}
