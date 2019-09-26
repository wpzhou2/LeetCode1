package algorithm;

/**
 * @Author: weipeng
 * @Date: 2019/6/2  0:11
 * @Description: 01背包
 **/

public class Package {
    public static void main(String[] args) {
        int[] w = { 0, 2, 3, 4, 5, 9 };
        int[] v = { 0, 3, 4, 5, 8, 10 };
        int N = 5, W = 20;
        int[][] b = new int[N][W];

        for (int k = 1; k <= N; k++) {
            for (int c = 1; c <= W; c++) {
                if (w[k] > c) {
                    b[k][c] = b[k - 1][c];
                } else {
                    int value1 = b[k - 1][c - w[k]] + v[k]; // 拿第k件物品
                    int value2 = b[k - 1][c]; // 不拿第k件物品
                    b[k][c] = Math.max(value1, value2);
                }
            }
        }
        System.out.println(b[5][20]);
    }
}
