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

    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                res.next = list2;
                list2 = list2.next;
            } else {
                res.next = list1;
                list1 = list1.next;
            }
            res = res.next;
        }
        if (list1 != null) {
            res.next = list1;
        } else {
            res.next = list2;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode list = lists[0];
        for (int i = 1; i < lists.length; i++) {
            list = merge2Lists(list, lists[i]);
        }
        return list;
    }
}
