package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/10  20:42
 * @Description:
 **/
//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//}
public class LC_111_MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        int res = Math.min(left, right) + 1;

        return res;
    }
}
