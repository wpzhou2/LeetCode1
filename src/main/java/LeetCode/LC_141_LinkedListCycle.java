package LeetCode;

import java.util.HashSet;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  16:12
 * @Description:
 **/
public class LC_141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(head!=null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        //使用一个快指针和一个慢指针,更快
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != slow){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
