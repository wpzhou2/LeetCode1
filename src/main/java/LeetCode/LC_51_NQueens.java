package LeetCode;


import java.util.ArrayList;
import java.util.List;


public class LC_51_NQueens {
    List<List<String>> lists;

    public List<List<String>> solveNQueens(int n) {
        lists = new ArrayList<List<String>>();
        //row�洢���Ƿ�ռ����Ϣ
        boolean[] row = new boolean[n];
        //tan�洢�������Ƿ�ռ����Ϣ
        boolean[] tan = new boolean[2 * n - 1];
        //cot�洢�������Ƿ�ռ����Ϣ
        boolean[] cot = new boolean[2 * n - 1];

        //q�洢�ʺ�λ����Ϣ
        int[] q = new int[n];

        //������ȱ���
        dfs(n, 0, row, tan, cot, q);

        return lists;
    }

    /**
     * @param n   �ʺ�����̴�С
     * @param col ��ǰ��������
     * @param row ��ǰ�ѱ�ռ�õ��У�false��δ��ռ�ã�true���ѱ�ռ��
     * @param tan ��ǰ�ѱ����е��У�false��δ��ռ�ã�true���ѱ�ռ��
     * @param cot ��ǰ�ѱ����е��У�false��δ��ռ�ã�true���ѱ�ռ��
     * @param q   ��ǰ�Ѽ�¼�Ļʺ�λ�ã�
     */
    private void dfs(int n, int col, boolean[] row, boolean[] tan, boolean[] cot, int[] q) {
        //�ж��Ƿ��Ѽ�¼�����һ��
        if (col == n) {
            List<String> list = new ArrayList<String>();
            String s;
            //����¼ֵ����list
            for (int i = 0; i < n; i++) {
                s = "";
                for (int j = 0; j < n; j++) {
                    //q[i] = j: ��ʾ�ʺ���ڵ�i�еĵ�j��
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

        //������ǰ�е�ÿһ��λ��
        for (int i = 0; i < n; i++) {
            //�����λ���Ѿ�����ǣ��Ͳ����루��֦��
            if (!row[i] && !tan[col + i] && !cot[i - col + n - 1]) {
                //δ����ǽ��磬��¼�ʺ�λ�ã������
                q[col] = i;

                row[i] = true;
                tan[col + i] = true;
                cot[i - col + n - 1] = true;

                //��������
                dfs(n, col + 1, row, tan, cot, q);

                //����
                row[i] = false;
                tan[col + i] = false;
                cot[i - col + n - 1] = false;
            }
        }
    }
}
