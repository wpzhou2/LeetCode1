package algorithm;

/**
 * @Author: weipeng
 * @Date: 2019/6/15  16:28
 * @Description:
 **/

public class LongestCommonSequence {

    //求解str1 和 str2 的最长公共子序列
    //c[i,j]表示：(x1,x2....xi) 和 (y1,y2...yj) 的最长公共子序列的长度。
    public static int LCS(String str1, String str2){
        int[][] c = new int[str1.length() + 1][str2.length() + 1];

        for(int row = 0; row <= str1.length(); row++)
            c[row][0] = 0;
        for(int column = 0; column <= str2.length(); column++)
            c[0][column] = 0;

        for(int i = 1; i <= str1.length(); i++)
            for(int j = 1; j <= str2.length(); j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    c[i][j] = c[i-1][j-1] + 1;
                else if(c[i][j-1] > c[i-1][j])
                    c[i][j] = c[i][j-1];
                else
                    c[i][j] = c[i-1][j];
            }
        return c[str1.length()][str2.length()];
    }

}
