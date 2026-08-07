/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    int counter = 1;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "D#";
        }
        return "D" + root.val + serialize(root.left) + serialize(root.right);
    }

    private TreeNode deserialize(String[] nodes) {
        if (nodes[counter].equals("#")) {
            counter++;
            return null;
        }
        TreeNode t = new TreeNode(Integer.parseInt(nodes[counter++]));
        t.left = deserialize(nodes);
        t.right = deserialize(nodes);
        return t;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.strip().split("D");
        return deserialize(nodes);
    }
}
