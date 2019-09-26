package Sort;

/**
 * @Author: weipeng
 * @Date: 2019/5/17  15:40
 * @Description:
 **/
public class BubbleSort {
    public static double[] bubbleSort(double[] arr) {
        //  冒泡排序就是重复n-1轮，每一轮将最大的数都将最大的数放在未排序组的最后
        //  每一轮：从开头开始每两个数值进行比较，一旦a>b，则交换他们的值
        //  重复n-1轮是因为：最后一轮只有一个数字，不用再排序了

        //  i:表示第几轮，一共是从第0轮到第n-2轮，共n-1轮
        //  j:表示每次相邻两个进行比较的数的前一个的位置
        //  第i轮：表示已经有i个数已经排好序
        //  故第i轮共需要比较n-i-1次

        /*
            在冒泡排序中，第1轮需要比较n-1次，第2轮需要比较n-2次……第n-1轮需要比较1次。
            因此，总的比较次数为（n-1）+（n-2）+…+1≈n^2/2。
            冒泡排序的时间复杂度为O（n2）
        */

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }



//    public static void main(String[] args) {
//        double arr[]={16,5,1,21,3,9,81,4,7};
//        arr = bubbleSort(arr);
//        for(double a:arr)
//            System.out.println(a);
//    }
}
