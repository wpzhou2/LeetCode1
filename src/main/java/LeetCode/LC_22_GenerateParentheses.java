package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/10  21:13
 * @Description:
 **/
public class LC_22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate(list, "", n, n);
        return list;
    }

    public void generate(List<String> list, String item, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(item);
            return;
        }
        if (left > 0) {
            generate(list, item + '(', left - 1, right);
        }
        if (left < right) {
            generate(list, item + ')', left, right - 1);
        }
    }

}
