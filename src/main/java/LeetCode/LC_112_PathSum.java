package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/26  14:12
 * @Description:
 **/
public class LC_112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null)
            return sum-root.val == 0;

        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
