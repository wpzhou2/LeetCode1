package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/26  0:25
 * @Description:
 **/
public class LC_110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(Math.abs(getDepth(root.left)-getDepth(root.right))<=1){
            return isBalanced(root.left) && isBalanced(root.right);
        }else{
            return false;
        }
    }

    int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            return 1 + Math.max(getDepth(root.left),getDepth(root.right));
        }
    }

//    public boolean isBalanced(TreeNode root) {
//        if (root == null)
//            return true;
//
//        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
//            return isBalanced(root.left) && isBalanced(root.right);
//        }else{
//            return false;
//        }
//
//    }
//
//    private int getDepth(TreeNode node) {
//        return node == null ? 0 : Math.max(getDepth(node.left),getDepth(node.right)) + 1;
//    }
}
