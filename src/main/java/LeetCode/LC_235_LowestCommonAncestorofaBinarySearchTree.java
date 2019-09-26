package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/16  14:27
 * @Description:
 **/
public class LC_235_LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        //保证p的根节点的值小于q的根节点的值
        TreeNode t;
        if (p.val > q.val) {
            t = p;
            p = q;
            q = t;
        }
        /*
         * 三种情况：
         * 1. 两个节点一个在左子树，一个在右子树
         * 2. 两个节点都在左子树
         * 3. 两个节点都在右子树
         * */
        if (p.val < root.val && root.val < q.val) {
            //一大一小：两个节点一个在左子树，一个在右子树
            return root;
        }
        if (p.val > root.val) {
            //最小值都大于根节点，故都在右子树
            return lowestCommonAncestor(root.right, p, q);
        }
        //根节点大于最大值，故都在左子树
        return lowestCommonAncestor(root.left, p, q);
    }
}
