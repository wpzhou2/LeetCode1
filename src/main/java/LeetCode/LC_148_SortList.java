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

    // �鲢����ʵ��
    private ListNode sort(ListNode head){
        if(head.next == null)
            return head;

        //1.�ҵ�������м��
        ListNode mid = getMidNode(head);
        //2.���м�㽫�����Ϊ������Ȼ��������ź���
        ListNode prePart = sort(head);
        ListNode posPart = sort(mid);
        //3.�������ź��������ϲ�
        ListNode ret = merge(prePart,posPart);

        return ret;
    }

    // �����м�ڵ㲢��������Ϊ������
    private ListNode getMidNode(ListNode head){
        ListNode fast = head, slow = head, pre = null;
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //���м�Ͽ�����
        return slow;
    }

    //�ϲ�������������
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
