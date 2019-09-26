package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/30  10:14
 * @Description:
 **/
public class LC_54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        //获得矩阵左上角和右下角的坐标
        int y1 = 0, y2 = matrix.length - 1;
        int x1 = 0, x2 = matrix[0].length - 1;

        while (y1 <= y2 && x1 <= x2) {
            //先是行循环
            for (int i = x1; i <= x2; i++) {
                list.add(matrix[y1][i]);
            }
            //这个是扣边界 以下三个跟这个类似的if语句都是扣边界，让x,y不要出去这个边界。
            if (y1 == y2) break;
            y1 ++;

            //列循环
            for (int j = y1; j <= y2; j++) {
                list.add(matrix[j][x2]);
            }
            if (x1 == x2) break;
            x2--;

            //然后再是行循环
            for (int i = x2; i >= x1; i--) {
                list.add(matrix[y2][i]);
            }
            if (y1 == y2) break;
            y2--;

            //最后列循环
            for (int j = y2; j >= y1; j--) {
                list.add(matrix[j][x1]);
            }
            if (x1 == x2) break;
            x1++;
        }
        return list;
    }
}
