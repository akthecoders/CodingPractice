/**
 * InsertionInTree
 */
import java.util.Queue;
import java.util.LinkedList;

public class InsertionInTree {
    static Node root;
    static Node temp = root;

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    static void inOrder(Node temp) {
        if (temp == null) {
            return;
        }
        inOrder(temp.left);
        System.out.print(temp.key + " ");
        inOrder(temp.right);
    }

    static void insert(Node temp , int data) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before insertion:");
        inOrder(root);

        int key = 12;
        insert(root, key);

        System.out.print("\nInorder traversal after insertion:");
        inOrder(root);
    }
}