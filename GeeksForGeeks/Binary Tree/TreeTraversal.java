/**
 * TreeTraversal
 */
public class TreeTraversal {
    static Node root;
    static class Node {
        int key;
        Node left, right;
        Node(int item) {
            key = item;
            left = null;
            right = null;
        }
    }

    static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.key + " ");
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.key + " ");
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        
    }
}