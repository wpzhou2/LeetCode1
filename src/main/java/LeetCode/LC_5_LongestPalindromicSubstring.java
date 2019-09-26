package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/6  12:13
 * @Description:
 **/
/*
Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.


Example 2:

Input: "cbbd"
Output: "bb"
* */
public class LC_5_LongestPalindromicSubstring {
//    public static String longestPalindromicSubstring(String s){
//        if(s==null || s.length()==0){
//            return s;
//        }
//        String res = "";
//        int max = 0;
//        boolean[][] dp = new boolean[s.length()][s.length()];
//
//        for(int j=0;j<s.length();j++){
//            for(int i=0;i<=j;i++){
//                dp[i][j] = s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]);
//                if(dp[i][j]){
//                    if(j-i+1>max){
//                        max = j-i+1;
//                        res = s.substring(i,j+1);
//                    }
//                }
//            }
//        }
//        System.out.println(max);
//        System.out.println(res);
//        return res;
//    }

    String res = "";
    int max = 0;

    public String longestPalindromicSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        System.out.println(res.length());
        System.out.println(res);
        return res;
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (right - left - 1 > max) {
            max = right - left - 1;
            res = s.substring(left + 1, right);
        }
    }
}
