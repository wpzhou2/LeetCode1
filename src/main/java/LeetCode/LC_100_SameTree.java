package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/26  23:40
 * @Description:
 **/
public class LC_100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)  return true;

        if(p!=null && q!=null && p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else{
            return false;
        }
    }
}
