package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/29  19:56
 * @Description:
 **/
public class LC_206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
