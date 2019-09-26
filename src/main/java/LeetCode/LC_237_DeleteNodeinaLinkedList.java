package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/29  21:00
 * @Description:
 **/
public class LC_237_DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
