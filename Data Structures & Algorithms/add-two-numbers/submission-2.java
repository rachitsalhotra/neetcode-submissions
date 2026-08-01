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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l1Prev = null;
        ListNode ans = l1;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum / 10 > 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            l1.val = sum % 10;
            l1Prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum / 10 > 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            l1.val = sum % 10;
            l1Prev = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            if (sum / 10 > 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum % 10);
            l1Prev.next = node;
            l1Prev = node;
            l2 = l2.next;
        }

        if (carry > 0) {
            ListNode node = new ListNode(1);
            l1Prev.next = node;
        }

        return ans;
    }
}
