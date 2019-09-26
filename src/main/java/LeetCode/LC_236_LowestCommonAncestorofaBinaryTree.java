package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/16  14:50
 * @Description:
 **/
public class LC_236_LowestCommonAncestorofaBinaryTree {
    public class Solution {
        public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null) return root;
            //根节点找到p,q，直接返回根节点
            if (root == p || root == q) return root;

            //根节点找不到p,q
            //1.去左子树找p,q
            TreeNode left = LowestCommonAncestor(root.left, p, q);
            //2.去右子树找p,q
            TreeNode right = LowestCommonAncestor(root.right, p, q);

            //p,q的位置有三种情况
            if (left != null && right != null) {
                //1. p，q分别在左右子树，直接返回根节点
                return root;
            } else if (left != null) {
                //2. p，q在左子树找到，直接返回左子树
                return left;
            } else if (right != null) {
                //3. p，q在右子树找到，直接返回右子树
                return right;
            }
            return null;
        }
    }
}
