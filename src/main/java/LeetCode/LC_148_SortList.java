package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  20:49
 * @Description:
 **/
public class LC_148_SortList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        return sort(head);
    }

    // 归并排序实现
    private ListNode sort(ListNode head){
        if(head.next == null)
            return head;

        //1.找到链表的中间点
        ListNode mid = getMidNode(head);
        //2.按中间点将链表分为两条，然后各自再排好序
        ListNode prePart = sort(head);
        ListNode posPart = sort(mid);
        //3.将两个排好序的链表合并
        ListNode ret = merge(prePart,posPart);

        return ret;
    }

    // 返回中间节点并把链表拆分为两部分
    private ListNode getMidNode(ListNode head){
        ListNode fast = head, slow = head, pre = null;
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //从中间断开链表
        return slow;
    }

    //合并两条有序链表
    private ListNode merge(ListNode p1, ListNode p2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                cur.next = p1;
                p1 = p1.next;
            }else{
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        cur.next = p1 == null ? p2 : p1;
        return dummy.next;
    }
}
