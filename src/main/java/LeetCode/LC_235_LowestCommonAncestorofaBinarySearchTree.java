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

        //��֤p�ĸ��ڵ��ֵС��q�ĸ��ڵ��ֵ
        TreeNode t;
        if (p.val > q.val) {
            t = p;
            p = q;
            q = t;
        }
        /*
         * ���������
         * 1. �����ڵ�һ������������һ����������
         * 2. �����ڵ㶼��������
         * 3. �����ڵ㶼��������
         * */
        if (p.val < root.val && root.val < q.val) {
            //һ��һС�������ڵ�һ������������һ����������
            return root;
        }
        if (p.val > root.val) {
            //��Сֵ�����ڸ��ڵ㣬�ʶ���������
            return lowestCommonAncestor(root.right, p, q);
        }
        //���ڵ�������ֵ���ʶ���������
        return lowestCommonAncestor(root.left, p, q);
    }
}
