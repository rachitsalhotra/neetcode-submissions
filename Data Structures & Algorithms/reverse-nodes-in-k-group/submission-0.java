/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int num = size / k;
        int ctr = k;
        ListNode prev = null;
        ListNode curr = head;
        ListNode prevNewHead = null;
        ListNode newHead = null;
        ListNode ans = null;
        while (num > 0) {
            if (ctr == k) {
                prevNewHead = newHead;
                newHead = curr;
            }
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
            ctr--;
            if (ctr == 0) {
                if (ans == null) {
                    ans = prev;
                }
                if (prevNewHead != null) {
                    prevNewHead.next = prev;
                }
                num--;
                ctr = k;
                prev = null;
            }
        }
        newHead.next = curr;
        return ans;
    }
}
