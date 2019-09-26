package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: weipeng
 * @Date: 2019/5/4  16:55
 * @Description:
 **/
public class LC_4_MedianOfTwoSortedArrays {
    public static void medianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        ArrayList<Integer> nums = new ArrayList<Integer>();

        int i1 = 0, i2 = 0;
        while (i1 < l1 || i2 < l2) {
            if (i1 < l1 && i2 < l2) {
                if (nums1[i1] >= nums2[i2]) {
                    nums.add(nums2[i2]);
                    i2++;
                } else {
                    nums.add(nums1[i1]);
                    i1++;
                }
            } else {
                if (i1 < l1) {
                    nums.add(nums1[i1++]);
                }
                if (i2 < l2) {
                    nums.add(nums2[i2++]);
                }
            }
        }
        int size = nums.size();
        int medium = size / 2;
        double res;
        if (size % 2 == 0) {
            //偶数个，则取medium+（medium-1）/2
            res = (nums.get(medium) + nums.get(medium - 1)) / 2.0;
        } else {
            //奇数个，则取medium的元素值
            res = nums.get(medium);
        }

        System.out.println("nums1:" + Arrays.toString(nums1));
        System.out.println("nums2:" + Arrays.toString(nums2));
        System.out.println("nums:" + nums);
        System.out.println("medium:" + res);
    }
}
