package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/15  0:03
 * @Description:
 **/
public class LC_36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    // i是行标，j是列标。行标决定一组block的起始位置（因为block为3行，所以除3取整得到组号，
                    // 又因为每组block为3个，所以需要乘3），列标再细分出是哪个block（因为block是3列，所以除3取整）
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
