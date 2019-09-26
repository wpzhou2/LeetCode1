package Sort;

/**
 * @Author: weipeng
 * @Date: 2019/5/17  14:30
 * @Description: ѡ������ÿ��ѡ��δ������С�ģ���ǰ��δ����ĵ�һλ����
 **/
public class SelectSort {
    public static int[] selectSort(int[] arr) {
        /*
        * 选择排序有n-1轮：第0轮到第n-2轮
        * 每轮都选择最小值
        * 然后将最小值的位置与未排序组的第一个位置交换
        * 第i轮表示：从i到n-1的数找出最小值然后放在i的位置上
        * */

        /*
            在选择排序中，第1轮需要比较n-1次，第2轮需要比较n-2次……第n-1轮需要比较1次。
            因此，总的比较次数为（n-1）+（n-2）+…+1≈n^2/2。
            选择排序的时间复杂度为O（n^2）
        */
        for (int i = 0; i < arr.length-1; i++) {
            int temp = arr[i];
            int flag = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (temp > arr[j]) {
                    temp = arr[j];
                    flag = j;
                }
            }
            arr[flag] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
