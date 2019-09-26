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


//二分法，更快
class Solution
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        int len=lists.length;

        if(lists==null||len==0)
            return null;
        if(len==1)
            return lists[0];

//    采用“二分”的思想进行两两合并：
//    第一轮循环，有序表lists[0]与lists[(K+1)/2]，lists[1]与lists[(K+1)/2+1]，lists[2]与lists[(K+1)/2+2]....，lists[K/2-1]与lists[K-1]。这样K个有序表就被组合成了K/2个有序表；
//    第二轮循环后将减少为K/4个有序表；
//    ...
//    直到组合成一个具有N个元素的有序表。

        while(len>1)//基于“二分”思想进行链表的两两组合
        {
            int mid = (len+1)/2;//二分
            for(int i=0;i<len/2;i++)
            {
                lists[i] = mergeTwoLists(lists[i],lists[i+mid]);
            }
            len = mid;
        }
        return lists[0];
    }

    //有序链表的组合，L1和L2为头结点，归并排序的核心思想
    public ListNode mergeTwoLists(ListNode L1,ListNode L2)
    {
        if(L1==null)return L2;
        if(L2==null)return L1;

        ListNode head=new ListNode(0);//保存结果的链表，头结点初始化
        ListNode phead=head;

        while(L1!=null&&L2!=null)//两个链表归并排序
        {
            if(L1.val <=L2.val)
            {
                phead.next=L1;//接入结果链表
                phead=phead.next;//移动指针
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

        return head.next;//初始化的第一个节点不属于结果
    }
}

