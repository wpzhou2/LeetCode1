package algorithm;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class PloygonAgent {
    private int n; //����α���
    private char[] op; //ÿ���ߵĶ�Ӧ�Ĳ�������1��ʼ������
    private int[] v; //ÿ��������ֵ����1��ʼ������
    private long[][][] m; //m[i][n][1]������һ��ʼɾ����i���ߣ�����Ϊn����������n�����㣩�����ܵõ������ֵ
    //m[i][n][0]������һ��ʼɾ����i���ߣ�����Ϊn���������ܵõ�����Сֵ
    private int[][][] cut; //��¼�ϲ��������
    private Stack<Integer> stack; //��ջ����ϲ��ߵ�˳��
    private int firstDelEdge; //��¼��������£���1��ɾ���ı�
    private long bestScore; //��¼���ŵ÷�

    public PloygonAgent(int n, long[][][] m, char[] op, int[] v) {
        this.n = n;
        this.m = m;
        this.op = op;
        this.v = v;
        this.cut = new int[n + 1][n + 1][2];
        this.stack = new Stack<Integer>();
    }

    private HashMap<String, Long> minMax(int i, int s, int j, HashMap<String, Long> resMap) {
        int r = (i + s - 1) % n + 1;//�°�ص����
        long a = m[i][s][0], b = m[i][s][1], c = m[r][j - s][0], d = m[r][j - s][1];
        if (op[r] == '+') {
            resMap.put("minf", a + c);
            resMap.put("maxf", b + d);
        } else {
            long[] e = new long[]{0, a * c, a * d, b * c, b * d};
            long minf = e[1], maxf = e[1];
            for (int k = 2; k < 5; k++) {
                if (minf > e[k]) minf = e[k];
                if (maxf < e[k]) maxf = e[k];
            }
            resMap.put("minf", minf);
            resMap.put("maxf", maxf);
        }
        return resMap;
    }

    private long polyMax() {
        HashMap<String, Long> resMap = new HashMap<String, Long>();
        for (int j = 2; j <= n; j++) { //���ĳ���
            for (int i = 1; i <= n; i++) { //ɾ����i����
                m[i][j][0] = Long.MAX_VALUE;
                m[i][j][1] = Long.MIN_VALUE;
                for (int s = 1; s < j; s++) { //�Ͽ���λ��
                    resMap = this.minMax(i, s, j, resMap);
                    if (m[i][j][0] > resMap.get("minf")) {
                        m[i][j][0] = resMap.get("minf");
                        cut[i][j][0] = s; //��¼����ȡ����Сֵ�Ķϵ�
                    }
                    if (m[i][j][1] < resMap.get("maxf")) {
                        m[i][j][1] = resMap.get("maxf");
                        cut[i][j][1] = s; //��¼����ȡ�����ֵ�Ķϵ�
                    }
                }
            }
        }

        bestScore = m[1][n][1];

        firstDelEdge = 1; //һ��ʼɾ���ıߣ���ʼ��Ϊ��һ����
        for (int i = 2; i <= n; i++) {
            if (bestScore < m[i][n][1]) {
                bestScore = m[i][n][1];
                firstDelEdge = i; //���һ��ʼɾ����i���и��ŵĽ���������
            }
        }
        for (int i = 1; i <= n; i++) { //һ��ʼɾ����i�������ܵõ���������
            System.out.println("i=" + i + " " + m[i][n][1]);
        }

        System.out.println("firstDelEdge=" + firstDelEdge);
        getBestSolution(firstDelEdge, n, true);
        while (!stack.empty()) { //��ӡ��ɾ����firstDelEdge���ߺ�����źϲ�˳��
            System.out.println("stack--> " + String.valueOf(stack.pop()));
        }

        return bestScore;
    }

    /**
     * ��ȡ���ŵĺϲ����У�����stack��
     *
     * @param i       ��ʾ�������ĸ����㿪ʼ
     * @param j       �����ĳ��ȣ���j=2����ʾ�������������㣩
     * @param needMax �Ƿ�ȡ�������ֵ���������ֵΪfalse����ȡ��������Сֵ
     */
    private void getBestSolution(int i, int j, boolean needMax) {
        int s, r;
        if (j == 1) return; //����ֻ��һ�����㣬ֱ�ӷ���
        if (j == 2) {
            s = cut[i][j][1];
            r = (i + s - 1) % n + 1;
            stack.push(r);
            return; //ֻ����������ʱ��û������������ݹ�
        }
        //�������������ϵĶ���ʱ�������ŵı���ջ
        s = needMax ? cut[i][j][1] : cut[i][j][0];//�ϰ���յ�
        r = (i + s - 1) % n + 1;//�°����㣬Ҳ������ضϵı�
        stack.push(r);
        if (this.op[r] == '+') { //���ϲ�����Ϊ"+"����ʱ
            if (needMax) { //����ϲ��õ��ĸ�����Ҫȡ�����ֵ
                getBestSolution(i, s, true);
                getBestSolution(r, j - s, true);
            } else { //����ϲ��õ��ĸ�����Ҫȡ����Сֵ
                getBestSolution(i, s, false);
                getBestSolution(r, j - s, false);
            }
        } else { //���ϲ�����Ϊ"*"����ʱ
            long a = m[i][s][0], b = m[i][s][1], c = m[r][j - s][0], d = m[r][j - s][1];
            long[] e = new long[]{0, a * c, a * d, b * c, b * d};
            long mergeMax = e[1], mergeMin = e[1];
            for (int k = 2; k <= 4; k++) {
                if (e[k] > mergeMax) mergeMax = e[k];
                if (e[k] < mergeMin) mergeMin = e[k];
            }
            long merge = (needMax) ? mergeMax : mergeMin; //�жϺϲ��õ��ĸ�����ȡ�����ȡ��С
            if (merge == e[1]) { //����1������2��ȡ��С
                getBestSolution(i, s, false);
                getBestSolution(r, j - s, false);
            } else if (merge == e[2]) { //����1ȡ��С������2ȡ���
                getBestSolution(i, s, false);
                getBestSolution(r, j - s, true);
            } else if (merge == e[3]) { //����1ȡ�������2ȡ��С
                getBestSolution(i, s, true);
                getBestSolution(r, j - s, false);
            } else { //����1������2��ȡ���
                getBestSolution(i, s, true);
                getBestSolution(r, j - s, true);
            }
        }
    }

    private void showPolygon() {
        StringBuilder midBuilder = new StringBuilder();
        StringBuilder botBuilder = new StringBuilder();
        for (int i = 1; i < v.length - 1; i++) {
            midBuilder.append("|").append(String.valueOf(v[i])).append("|");
            midBuilder.append("--").append(op[i + 1]).append("--");
        }
        midBuilder.append("|").append(String.valueOf(v[v.length - 1])).append("|");
        botBuilder.append(" ");
        for (int i = 1; i < midBuilder.length() - 1; i++) {
            if (i == 1 || i == midBuilder.length() - 2) botBuilder.append("|");
            else if (i == (midBuilder.length() - 1) / 2) botBuilder.append(op[1]);
            else botBuilder.append("_");
        }
        System.out.println(midBuilder.toString());
        System.out.println(botBuilder.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long[][][] m = new long[n + 1][n + 1][2];
            char[] op = new char[n + 1];
            int[] v = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                op[i] = scanner.next().charAt(0);
                v[i] = scanner.nextInt();
            }
            PloygonAgent ploygonAgent = new PloygonAgent(n, m, op, v);
            ploygonAgent.showPolygon();
            for (int i = 1; i <= n; i++) {
                m[i][1][0] = m[i][1][1] = v[i];
            }
            long result = ploygonAgent.polyMax();
            System.out.println("BestScore=" + result);
        }
    }
}
