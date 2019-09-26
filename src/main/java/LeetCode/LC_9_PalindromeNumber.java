package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  19:36
 * @Description:
 **/
public class LC_9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int start = 0;
        int end = s.length()-1;

        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
