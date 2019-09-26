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
            //���ڵ��ҵ�p,q��ֱ�ӷ��ظ��ڵ�
            if (root == p || root == q) return root;

            //���ڵ��Ҳ���p,q
            //1.ȥ��������p,q
            TreeNode left = LowestCommonAncestor(root.left, p, q);
            //2.ȥ��������p,q
            TreeNode right = LowestCommonAncestor(root.right, p, q);

            //p,q��λ�����������
            if (left != null && right != null) {
                //1. p��q�ֱ�������������ֱ�ӷ��ظ��ڵ�
                return root;
            } else if (left != null) {
                //2. p��q���������ҵ���ֱ�ӷ���������
                return left;
            } else if (right != null) {
                //3. p��q���������ҵ���ֱ�ӷ���������
                return right;
            }
            return null;
        }
    }
}
