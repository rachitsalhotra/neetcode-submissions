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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;

        ListNode test = head;
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        test = prev;
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
        // head - 2,4,6
        // prev - 8,6
        // 2,8 4,6
        while (prev != null && head != null && prev.next != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = prev.next;
            head.next.next = temp;
            head = temp;
        }
    }
}
