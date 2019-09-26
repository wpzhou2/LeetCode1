package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/10  20:28
 * @Description:
 **/
public class LC_104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int res = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
            return res;
        }
    }
}
