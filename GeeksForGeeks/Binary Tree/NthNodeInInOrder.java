/**
 * NthNodeInInOrder
 */
public class NthNodeInInOrder {

    static int count = 0;
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return (node);
    }

    public static void main(String[] args) {
        Node root = newNode(10);
        root.left = newNode(20);
        root.right = newNode(30);
        root.left.left = newNode(40);
        root.left.right = newNode(50);
        int n = 4;
        NthInorder(root, n);
    }

    static void NthInorder(Node root, int n) {
        if(root == null) {
            return;
        }

        NthInorder(root.left, n);
        count++;
        if(count == n) {
            System.out.println(root.data);
            return;
        }
        NthInorder(root.right, n);

    }
}