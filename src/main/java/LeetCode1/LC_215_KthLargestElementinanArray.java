package LeetCode1;

import java.util.PriorityQueue;

/**
 * @Author: weipeng
 * @Date: 2019/5/30  14:33
 * @Description:
 **/
public class LC_215_KthLargestElementinanArray {
    //使用堆，优先队列，最快,但这是使用API....
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int num:nums){
            heap.offer(num);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }

    //冒泡排序，找到第k大的数就直接返回
    public int findKthLargest1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
            if(k==1){
                return nums[nums.length-i-1];
            }
            k--;
        }

        return -1;
    }

    //直接快排完，然后返回第k大的数
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || nums.length < k) {
            return -1;
        }
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }

    public int[] quickSort(int arr[], int left, int right) {
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
