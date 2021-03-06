package LeetCode;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class PloygonAgent {
    private int n; //多边形边数
    private char[] op; //每条边的对应的操作（从1开始计数）
    private int[] v; //每个顶点数值（从1开始计数）
    private long[][][] m; //m[i][n][1]：代表一开始删除第i条边，长度为n的链（包含n个顶点），所能得到的最大值
    //m[i][n][0]：代表一开始删除第i条边，长度为n的链，所能得到的最小值
    private int[][][] cut; //记录合并点的数组
    private Stack<Integer> stack; //用栈保存合并边的顺序
    private int firstDelEdge; //记录最优情况下，第1条删除的边
    private long bestScore; //记录最优得分

    public PloygonAgent(int n, long[][][] m, char[] op, int[] v) {
        this.n = n;
        this.m = m;
        this.op = op;
        this.v = v;
        this.cut = new int[n + 1][n + 1][2];
        this.stack = new Stack<Integer>();
    }

    private HashMap<String, Long> minMax(int i, int s, int j, HashMap<String, Long> resMap) {
        int r = (i + s - 1) % n + 1;//下半截的起点
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
        for (int j = 2; j <= n; j++) { //链的长度
            for (int i = 1; i <= n; i++) { //删除第i条边
                m[i][j][0] = Long.MAX_VALUE;
                m[i][j][1] = Long.MIN_VALUE;
                for (int s = 1; s < j; s++) { //断开的位置
                    resMap = this.minMax(i, s, j, resMap);
                    if (m[i][j][0] > resMap.get("minf")) {
                        m[i][j][0] = resMap.get("minf");
                        cut[i][j][0] = s; //记录该链取得最小值的断点
                    }
                    if (m[i][j][1] < resMap.get("maxf")) {
                        m[i][j][1] = resMap.get("maxf");
                        cut[i][j][1] = s; //记录该链取得最大值的断点
                    }
                }
            }
        }

        bestScore = m[1][n][1];

        firstDelEdge = 1; //一开始删除的边，初始化为第一条边
        for (int i = 2; i <= n; i++) {
            if (bestScore < m[i][n][1]) {
                bestScore = m[i][n][1];
                firstDelEdge = i; //如果一开始删除第i边有更优的结果，则更新
            }
        }
        for (int i = 1; i <= n; i++) { //一开始删除第i条边所能得到的最大分数
            System.out.println("i=" + i + " " + m[i][n][1]);
        }

        System.out.println("firstDelEdge=" + firstDelEdge);
        getBestSolution(firstDelEdge, n, true);
        while (!stack.empty()) { //打印在删除第firstDelEdge条边后的最优合并顺序
            System.out.println("stack--> " + String.valueOf(stack.pop()));
        }

        return bestScore;
    }

    /**
     * 获取最优的合并序列，存入stack中
     *
     * @param i       表示子链从哪个顶点开始
     * @param j       子链的长度（如j=2，表示链中有两个顶点）
     * @param needMax 是否取链的最大值，如果传入值为false，则取子链的最小值
     */
    private void getBestSolution(int i, int j, boolean needMax) {
        int s, r;
        if (j == 1) return; //链中只有一个顶点，直接返回
        if (j == 2) {
            s = cut[i][j][1];
            r = (i + s - 1) % n + 1;
            stack.push(r);
            return; //只有两个顶点时，没有子链，无须递归
        }
        //链中有两个以上的顶点时，将最优的边入栈
        s = needMax ? cut[i][j][1] : cut[i][j][0];//上半截终点
        r = (i + s - 1) % n + 1;//下半截起点，也是两半截断的边
        stack.push(r);
        if (this.op[r] == '+') { //当合并计算为"+"操作时
            if (needMax) { //如果合并得到的父链需要取得最大值
                getBestSolution(i, s, true);
                getBestSolution(r, j - s, true);
            } else { //如果合并得到的父链需要取得最小值
                getBestSolution(i, s, false);
                getBestSolution(r, j - s, false);
            }
        } else { //当合并计算为"*"操作时
            long a = m[i][s][0], b = m[i][s][1], c = m[r][j - s][0], d = m[r][j - s][1];
            long[] e = new long[]{0, a * c, a * d, b * c, b * d};
            long mergeMax = e[1], mergeMin = e[1];
            for (int k = 2; k <= 4; k++) {
                if (e[k] > mergeMax) mergeMax = e[k];
                if (e[k] < mergeMin) mergeMin = e[k];
            }
            long merge = (needMax) ? mergeMax : mergeMin; //判断合并得到的父链是取最大还是取最小
            if (merge == e[1]) { //子链1和子链2都取最小
                getBestSolution(i, s, false);
                getBestSolution(r, j - s, false);
            } else if (merge == e[2]) { //子链1取最小，子链2取最大
                getBestSolution(i, s, false);
                getBestSolution(r, j - s, true);
            } else if (merge == e[3]) { //子链1取最大，子链2取最小
                getBestSolution(i, s, true);
                getBestSolution(r, j - s, false);
            } else { //子链1和子链2都取最大
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
