/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node cloneGraph(Node node, HashMap<Integer, Node> visited) {
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        ArrayList<Node> newNeighbors = new ArrayList<>();
        Node newNode = new Node(node.val, newNeighbors);
        visited.put(node.val, newNode);
        for (Node neighbor: node.neighbors) {
            Node newNeighbor = cloneGraph(neighbor, visited);
            newNeighbors.add(newNeighbor);
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return cloneGraph(node, new HashMap<>());
    }
}