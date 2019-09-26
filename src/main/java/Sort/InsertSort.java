package Sort;

/**
 * @Author: weipeng
 * @Date: 2019/5/17  15:15
 * @Description:
 **/
public class InsertSort {
    public static int[] insertSort(int[] arr) {
        /*
        * 插入排序：有n-1轮，第1轮到第n-1轮
        * 第i轮表示：将第i个位置的数字比前面i-1个数字比较，插入到正确的位置
        * 实际上，前面i-1个数字已经排好序，一开始只需要看看第i个位置和第i-1个位置的数字的大小比较
        * */
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            if (temp < arr[j]) {
                while (j >= 0 && temp < arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

}
