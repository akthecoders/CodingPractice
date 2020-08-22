//Convert Binary Search Tree to Sorted Doubly Linked List

public class P426 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        solver(root);
        last.right = first;
        first.left = last;
        return first;
    }

    public void solver(Node node) {
        if (node != null) {
            solver(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            } else {
                first = node;
            }
            last = node;
            solver(node.right);
        }
    }
}