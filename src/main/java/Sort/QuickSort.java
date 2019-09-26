package Sort;

import java.util.ArrayList;

/**
 * @Author: weipeng
 * @Date: 2019/5/17  19:08
 * @Description:
 **/
public class QuickSort {

    public static int[] quickSort(int arr[], int left, int right) {
        if (left >= right) return null;

        int start = left;
        int end = right;
        int pivot = arr[left];

        while (left != right) {
            while (left < right && arr[right] >= pivot)
                right--;
            arr[left] = arr[right];

            while (left < right && arr[left] < pivot)
                left++;
            arr[right] = arr[left];
        }

        arr[right] = pivot;

        quickSort(arr, start, left - 1);
        quickSort(arr, right + 1, end);

        return arr;
    }

}




























