/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        Node curr = newHead;
        Node oldHead = head;
        head = head.next;
        while (head != null) {
            Node node = new Node(head.val);
            map.put(head, node);
            curr.next = node;
            curr = curr.next;
            head = head.next;
        }
        curr.next = null;
        curr = newHead;
        while (oldHead != null) {
            curr.random = oldHead.random != null ? map.get(oldHead.random) : null;
            oldHead = oldHead.next;
            curr = curr.next;
        }
        return newHead;
    }
}
