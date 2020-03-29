/**
 * RemoveBSTOutsideRange
 */
public class RemoveBSTOutsideRange {

    static class Node {
        int data;
        Node left, right;

        // constructor
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node removeOutRange(Node root, int min, int max) {
        if(root == null) {
            return null;
        }

        root.left = removeOutRange(root.left, min, max);
        root.right = removeOutRange(root.right, min, max);

        if(root.data < min) {
            Node rChild = root.right;
            root = null;
            return rChild;
        }
        if(root.data > max) {
            Node lChild = root.left;
            root = null;
            return lChild;
        }
        return root;
    }
    
    public static void inOrder(Node root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(5); /* 5 */
        root1.left = new Node(3); /* / \ */
        root1.right = new Node(7); /* 3 7 */
        root1.left.left = new Node(2); /* / \ / \ */
        root1.left.right = new Node(4); /* 2 4 6 8 */
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);
        
        inOrder(root1);
        System.out.println();
        Node root = removeOutRange(root1, 3, 6);
        inOrder(root);
    }
}