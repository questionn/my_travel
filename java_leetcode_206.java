/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode mid = head;
        ListNode curNext = head.next;
        while(mid != null){
            mid.next = prev;
            prev = mid;
            mid = curNext;
            if(curNext != null){
                curNext = curNext.next;
            }
        }
        return prev;
    }
}