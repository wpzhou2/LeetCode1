package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  16:56
 * @Description:
 **/
public class LC_142_LinkedListCycleII {
    //不知为何，这个函数在LeetCode有错
    public ListNode detectCycle(ListNode head){
        boolean hasCircle = false;

        //1.使用快慢链表检查是否有环
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                hasCircle = true;
                break;
            }
        }

        //2.找出环的第一个节点
        //设起点到环的第一个点的距离为a，环的第一个点到快慢指针相遇的距离为b，为两个距离为a+b
        //由于快指针的速度是慢指针的两倍，所以此时慢指针再走a+b的距离可以到达相遇点
        //相遇点的距离减去b就是环的第一个点，所以此时慢指针再走a的距离可以到环的第一个点
        //而链起点再走a的距离也可以到达环的第一个点
        if(hasCircle){
            ListNode start = head;
            while(start != slow){
                start = start.next;
                slow = slow.next;
            }
            return start;
        }else{
            return null;
        }
    }



    public ListNode detectCycle1(ListNode head) {
        if (head==null||head.next==null) {
            return null;
        }
        if (hasCycle(head)) {
            //链表有环.
            ListNode fast = head.next.next;
            ListNode slow = head.next;
            while (fast != slow) {
                fast = fast.next.next;
                slow = slow.next;
            }

            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }else {
            //链表无环.
            return null;
        }
    }

    public boolean hasCycle(ListNode root) {
        ListNode fast = root.next.next;
        ListNode slow = root.next;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == slow) {
            return true;
        }else {
            return false;
        }
    }
}
