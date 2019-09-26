package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/30  14:03
 * @Description:
 **/
public class LC_88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int m2 = m;
        for(int i=0;i<nums1.length;i++){
            if(m2<nums1.length){
                nums1[m2] = nums2[i];
            }
            m2++;
        }
        quickSort(nums1, 0, m+n-1);
    }

    public int[] quickSort(int arr[], int left, int right) {
        if (left >= right) return null;

        int start = left;
        int end = right;
        int pivot = arr[left];//让pivot记住最左边的值，将其作为基准，同时最左边的位置可以用来放其他值

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
