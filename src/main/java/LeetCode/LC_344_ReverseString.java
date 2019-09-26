package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  13:23
 * @Description:
 **/
public class LC_344_ReverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while(i<j){
            swap(s,i,j);
            i++;
            j--;
        }
    }

    void swap(char[] s,int i,int j){
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
