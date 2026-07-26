class MinStack {
    class Node<T> {
        Node<T> next;
        int data;

        public Node(Node<T> next, int data) {
            this.next = next;
            this.data = data;
        }
    }

    Node<Integer> head;
    int min;

    public MinStack() {
        head = null;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val < min) {
            min = val;
        }
        Node<Integer> node = new Node<>(head, val);
        head = node;
    }
    
    public void pop() {
        head = head.next;
        Node<Integer> temp = head;

        min = Integer.MAX_VALUE;
        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return min;
    }
}
