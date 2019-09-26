package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/30  0:10
 * @Description:
 **/
public class LC_230_KthSmallestElementinaBST {
    private int index = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        midOrder(root,k);
        return res;
    }

    private void midOrder(TreeNode root,int k){
        if (root==null) return;

        midOrder(root.left,k);

        index++;
        if(index==k){
            res=root.val;
            return;
        }

        midOrder(root.right,k);
    }
}
