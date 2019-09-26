package LeetCode;


import java.util.ArrayList;
import java.util.List;


public class LC_51_NQueens {
    List<List<String>> lists;

    public List<List<String>> solveNQueens(int n) {
        lists = new ArrayList<List<String>>();
        //row存储行是否被占用信息
        boolean[] row = new boolean[n];
        //tan存储正切线是否被占用信息
        boolean[] tan = new boolean[2 * n - 1];
        //cot存储反切线是否被占用信息
        boolean[] cot = new boolean[2 * n - 1];

        //q存储皇后位置信息
        int[] q = new int[n];

        //深度优先遍历
        dfs(n, 0, row, tan, cot, q);

        return lists;
    }

    /**
     * @param n   皇后和棋盘大小
     * @param col 当前遍历的列
     * @param row 当前已被占用的行，false：未被占用；true：已被占用
     * @param tan 当前已被正切的行，false：未被占用；true：已被占用
     * @param cot 当前已被反切的行，false：未被占用；true：已被占用
     * @param q   当前已记录的皇后位置，
     */
    private void dfs(int n, int col, boolean[] row, boolean[] tan, boolean[] cot, int[] q) {
        //判断是否已记录到最后一列
        if (col == n) {
            List<String> list = new ArrayList<String>();
            String s;
            //将记录值加入list
            for (int i = 0; i < n; i++) {
                s = "";
                for (int j = 0; j < n; j++) {
                    //q[i] = j: 表示皇后放在第i列的第j行
                    if (j == q[i]) {
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                list.add(s);
            }
            lists.add(list);
        }

        //遍历当前列的每一个位置
        for (int i = 0; i < n; i++) {
            //如果该位置已经被标记，就不进入（减枝）
            if (!row[i] && !tan[col + i] && !cot[i - col + n - 1]) {
                //未被标记进如，记录皇后位置，并标记
                q[col] = i;

                row[i] = true;
                tan[col + i] = true;
                cot[i - col + n - 1] = true;

                //继续深入
                dfs(n, col + 1, row, tan, cot, q);

                //回溯
                row[i] = false;
                tan[col + i] = false;
                cot[i - col + n - 1] = false;
            }
        }
    }
}
