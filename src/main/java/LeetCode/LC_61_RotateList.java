package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/30  11:00
 * @Description:
 **/
public class LC_61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }

        int length = 0;
        ListNode curr = head;
        while(curr!=null){
            length++;
            curr = curr.next;
        }

        if(length==1 || k % length==0) return head;

        int offset = length - k % length -1;
        ListNode curr1 = head;
        for(int i=0;i<offset;i++){
            curr1 = curr1.next;
        }

        ListNode curr2 = curr1.next;
        ListNode res = curr1.next;
        curr1.next = null;

        while(curr2 !=null && curr2.next != null){
            curr2 = curr2.next;
        }
        curr2.next = head;

        return res;
    }
}
