package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/28  14:58
 * @Description:
 **/
public class LC_23_MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode head = lists[0];
        int index = 1;
        while (index < lists.length) {
            head = mergeTwoLists(head, lists[index]);
            index++;
        }
        return head;
    }

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


//���ַ�������
class Solution
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        int len=lists.length;

        if(lists==null||len==0)
            return null;
        if(len==1)
            return lists[0];

//    ���á����֡���˼����������ϲ���
//    ��һ��ѭ���������lists[0]��lists[(K+1)/2]��lists[1]��lists[(K+1)/2+1]��lists[2]��lists[(K+1)/2+2]....��lists[K/2-1]��lists[K-1]������K�������ͱ���ϳ���K/2�������
//    �ڶ���ѭ���󽫼���ΪK/4�������
//    ...
//    ֱ����ϳ�һ������N��Ԫ�ص������

        while(len>1)//���ڡ����֡�˼�����������������
        {
            int mid = (len+1)/2;//����
            for(int i=0;i<len/2;i++)
            {
                lists[i] = mergeTwoLists(lists[i],lists[i+mid]);
            }
            len = mid;
        }
        return lists[0];
    }

    //�����������ϣ�L1��L2Ϊͷ��㣬�鲢����ĺ���˼��
    public ListNode mergeTwoLists(ListNode L1,ListNode L2)
    {
        if(L1==null)return L2;
        if(L2==null)return L1;

        ListNode head=new ListNode(0);//������������ͷ����ʼ��
        ListNode phead=head;

        while(L1!=null&&L2!=null)//��������鲢����
        {
            if(L1.val <=L2.val)
            {
                phead.next=L1;//����������
                phead=phead.next;//�ƶ�ָ��
                L1=L1.next;
            }
            else
            {
                phead.next=L2;
                phead=phead.next;
                L2=L2.next;
            }
        }
        if(L1!=null)
            phead.next=L1;
        else
            phead.next=L2;

        return head.next;//��ʼ���ĵ�һ���ڵ㲻���ڽ��
    }
}

