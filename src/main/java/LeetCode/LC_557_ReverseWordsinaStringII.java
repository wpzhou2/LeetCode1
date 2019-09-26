package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/29  20:22
 * @Description:
 **/
public class LC_557_ReverseWordsinaStringII {
    public String reverseWords1(String s) {
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for(int i=words.length-1;i>=0;i--){
            res.append(new StringBuilder(words[i]).reverse()).append(" ");
        }
        return res.toString().trim();
    }


    //这种方法不太好，有点慢
    public String reverseWords(String s) {
        String res = "";
        String[] words = s.split(" ");
        for(String word: words){
            res = res + reverse(word)+" ";
        }
        return res.trim();
    }
    String reverse(String word){
        String str = "";
        for(int i=word.length()-1;i>=0;i--){
            str = str+word.charAt(i);
        }
        return str;
    }
}
