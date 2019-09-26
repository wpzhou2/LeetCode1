package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  18:10
 * @Description:
 **/
public class LC_21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }else{
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            curr.next = l2;
        }
        if(l2==null){
            curr.next = l1;
        }

        return dummyHead.next;
    }
}
