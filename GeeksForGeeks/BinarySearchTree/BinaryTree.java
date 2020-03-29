/**
 * BinaryTree
 */
public class BinaryTree {

    static class Node {
        int data;
        Node left = null, right = null;
        public Node(int item) {
            data = item;
        }
    }

    static Node root;

    public static Node insert(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(root.data < data) {
            root.right = insert(root.right, data);
        }
        else if(root.data > data) {
            root.left = insert(root.left, data);
        }
        return root;
    }

    public static void traverse(Node root) {
        if(root == null) {
            return;
        }
        traverse(root.left);
        System.out.print(root.data + " ");
        traverse(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 5);
        traverse(root);
        System.out.println();
        root = insert(root, 2);
        traverse(root);
        System.out.println();
        root = insert(root, 3);
        traverse(root);
        System.out.println();
        root = insert(root, 4);
        traverse(root);
        System.out.println();
        root = insert(root, 6);
        traverse(root);
        System.out.println();
        root = insert(root, 7);
        traverse(root);
        System.out.println();
    }
}