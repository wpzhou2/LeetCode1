package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  16:56
 * @Description:
 **/
public class LC_142_LinkedListCycleII {
    //��֪Ϊ�Σ����������LeetCode�д�
    public ListNode detectCycle(ListNode head){
        boolean hasCircle = false;

        //1.ʹ�ÿ����������Ƿ��л�
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

        //2.�ҳ����ĵ�һ���ڵ�
        //����㵽���ĵ�һ����ľ���Ϊa�����ĵ�һ���㵽����ָ�������ľ���Ϊb��Ϊ��������Ϊa+b
        //���ڿ�ָ����ٶ�����ָ������������Դ�ʱ��ָ������a+b�ľ�����Ե���������
        //������ľ����ȥb���ǻ��ĵ�һ���㣬���Դ�ʱ��ָ������a�ľ�����Ե����ĵ�һ����
        //�����������a�ľ���Ҳ���Ե��ﻷ�ĵ�һ����
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
            //�����л�.
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
            //�����޻�.
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
