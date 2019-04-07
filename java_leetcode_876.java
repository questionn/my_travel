/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int getLength(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
            return count;
    }
    public ListNode middleNode(ListNode head){
        int middle = getLength(head)/2;
        ListNode cur = head;
        for (int i = 0; i < middle; i++) {
            cur = cur.next;
        }
        return cur;
    }
}