class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }
    HashMap<Integer, Node> nodeMap;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        nodeMap = new HashMap<>();
        head = null;
        tail = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = null;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            if (node == tail && node.prev != null) {
                tail = node.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }
        }
        return node != null ? node.value : -1;
    }
    
    public void put(int key, int value) {
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            if (node == tail && node.prev != null) {
                tail = node.prev;
            }
            node.value = value;
            if (node.prev != null) {
                node.prev.next = node.next;
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }
        } else {
            if (nodeMap.size() == capacity) {
                nodeMap.remove(tail.key);
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                } else {
                    head = null;
                }
            }
            node = new Node();
            if (tail == null) {
                tail = node;
            }
            node.key = key;
            node.value = value;
            node.prev = null;
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            nodeMap.put(key, node);
        }
    }
}
