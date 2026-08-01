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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode res = null;
        ListNode head = null;

        while (curr1 != null && curr2 != null) {
            if (curr1.val > curr2.val) {
                if (res == null) {
                    res = curr2;
                    head = res;
                } else {
                    res.next = curr2;
                    res = res.next;
                }
                curr2 = curr2.next;
            } else {
                if (res == null) {
                    res = curr1;
                    head = res;
                } else {
                    res.next = curr1;
                    res = res.next;
                }
                curr1 = curr1.next;
            }
        }

        while (curr2 != null) {
            if (res == null) {
                res = curr2;
                head = res;
            } else {
                res.next = curr2;
                res = res.next;
            }
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            if (res == null) {
                res = curr1;
                head = res;
            } else {
                res.next = curr1;
                res = res.next;
            }
            curr1 = curr1.next;
        }
        
        return head;
    }
}