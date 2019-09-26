package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/26  15:03
 * @Description:
 **/
public class LC_784_LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList();
        char[] arr = S.toCharArray();
        function(list,arr,0);
        return list;
    }


    public void function(List<String> list, char[] arr, int i) {
        if( i >= arr.length ) {
            list.add(new String(arr));
            return;
        }

        function(list,arr,i+1);  // i 位置字符没有动。

        if( !Character.isDigit(arr[i])) {  // 将 i 位置的非数字字符 大变小，或者 小变大。
            if( Character.isUpperCase(arr[i]) ) {
                arr[i] = Character.toLowerCase(arr[i]);
                function(list,arr,i+1);
                arr[i] = Character.toUpperCase(arr[i]);
            } else {
                arr[i] = Character.toUpperCase(arr[i]);
                function(list,arr,i+1);
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }
    }
}
