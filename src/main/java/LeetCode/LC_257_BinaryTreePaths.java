package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/26  23:47
 * @Description:
 **/
public class LC_257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root==null) return res;

        solve(root, "", res);

        return res;
    }

    public void solve(TreeNode root,String str,List<String> res){
        if(root == null) return;

        str += root.val;

        if(root.left == null && root.right == null){
            res.add(str);
        }else{
            solve(root.left,str+"->",res);
            solve(root.right,str+"->",res);
        }
    }


}
