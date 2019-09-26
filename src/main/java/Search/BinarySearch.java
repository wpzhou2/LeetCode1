package Search;

/**
 * @Author: weipeng
 * @Date: 2019/5/18  11:15
 * @Description:
 **/
public class BinarySearch {

    //非递归
    public static int binarySearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid, midValue;

        while (low <= high) {
            mid = (high + low) / 2;
            midValue = arr[mid];

            if (midValue == target) return mid;
            else if (midValue < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    //递归实现
    int BinarySearch (int x, int a[], int low, int high ){
        if (low > high) return -1;

        int mid = (low+high)/2;

        if(x == a[mid])   return mid;
        if(x > a[mid])    return BinarySearch(x, a, mid+1, high);
        else              return BinarySearch(x, a, low, mid-1);
    }

}
