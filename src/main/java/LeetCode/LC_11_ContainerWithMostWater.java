package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  19:54
 * @Description:
 **/
public class LC_11_ContainerWithMostWater {
    //暴力破解法，双重循环
    public int maxArea(int[] height) {
        int res = -1;
        int curr;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                curr = (j-i) * Math.min(height[i],height[j]);
                res = Math.max(res,curr);
            }
        }
        return res;
    }

    //双指针法
    public int maxArea1(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while(l<r){
            max = Math.max(max, (r-l)*Math.min(height[r],height[l]));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
