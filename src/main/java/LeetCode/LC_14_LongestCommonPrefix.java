package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  13:18
 * @Description:
 **/
public class LC_14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        if (strs.length == 0)
            return "";

        // 获取最短字符串，以其长度参考
        int minLength = strs[0].length();
        for(int i = 0; i < strs.length; i ++) {
            if(strs[i].length() < minLength)
                minLength = strs[i].length();
        }

        StringBuilder commonPrefix = new StringBuilder("");

        // 检索字符串的字母，并逐次比较
        for(int j = 0; j < minLength; j++) {
            for(int k = 0; k < strs.length - 1; k++) {
                if(strs[k].charAt(j) != strs[k + 1].charAt(j))
                    return commonPrefix.toString();
            }
            commonPrefix.append(strs[0].charAt(j));
        }

        return commonPrefix.toString();
    }
}
