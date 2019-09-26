package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/29  21:12
 * @Description:
 **/
public class LC_238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;

        //�㷨indexΪi������ߵ������ۻ�
        for(int i=1;i<nums.length;i++){
            left[i] = left[i-1] * nums[i-1];
        }
        //�㷨indexΪi�����ұߵ������ۻ�
        for(int i=nums.length-2;i>=0;i--){
            right[i] = right[i+1] * nums[i+1];
        }
        //�㷨indexΪi����Ϊ���ұߵ������ۻ� * ��ߵ������ۻ���
        for(int i=0;i<nums.length;i++){
            nums[i] = left[i]*right[i];
        }
        return nums;
    }
}
