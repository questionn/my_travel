/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.*;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        //无节点的话
        if(listNode == null){
            return list;
        }
        //两个节点的话
        ListNode head = listNode;
        if(head.next.next == null){
            list.add(head.next.val);
            list.add(head.val);
            return list;
        }
        //链表反转
        ListNode la = listNode;
        ListNode mid = listNode.next;
        ListNode pre = mid.next;
        la.next = null;
        while(mid != null){
            if(pre != null){
                
                mid.next = la;
                la = mid;
                mid = pre;
                pre = pre.next;
            }else{
                
                mid.next = la;
                la = mid;
                mid = null;
            }

        }
        //打印
        ListNode fin = la;
        list.add(fin.val);
        while(fin.next != null){
            ListNode tmp = fin.next;
            list.add(tmp.val);
            fin = fin.next;
        }
        return list;
    }
}