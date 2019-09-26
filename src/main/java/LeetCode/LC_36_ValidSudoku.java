package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/15  0:03
 * @Description:
 **/
public class LC_36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // ��¼ĳ�У�ĳλ�����Ƿ��Ѿ����ڷ�
        boolean[][] row = new boolean[9][9];
        // ��¼ĳ�У�ĳλ�����Ƿ��Ѿ����ڷ�
        boolean[][] col = new boolean[9][9];
        // ��¼ĳ 3x3 �����ڣ�ĳλ�����Ƿ��Ѿ����ڷ�
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    // i���б꣬j���бꡣ�б����һ��block����ʼλ�ã���ΪblockΪ3�У����Գ�3ȡ���õ���ţ�
                    // ����Ϊÿ��blockΪ3����������Ҫ��3�����б���ϸ�ֳ����ĸ�block����Ϊblock��3�У����Գ�3ȡ����
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
