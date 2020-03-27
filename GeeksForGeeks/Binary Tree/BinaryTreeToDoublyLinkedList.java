/**
 * BinaryTreeToDoublyLinkedList
 */
public class BinaryTreeToDoublyLinkedList {
    static Node root;
    static class Node {
        int data;
        Node left, right;
    
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static Node binarytree2listUtil(Node root) {
        if(root == null) {
            return null;
        }
        if(root.left != null) {
            Node left = binarytree2listUtil(root.left);
            for(; left.right != null; left = left.right);

            left.right = root;
            root.left = left;
        }
        
        if(root.right != null) {
            Node right = binarytree2listUtil(root.right);
            for(; right.left != null; right = right.left);
            root.right = right;
            right.left = root;
        }

        return root;
    }

    static Node bintree2list(Node node) {
        if (node == null)
            return node;

         node = binarytree2listUtil(node);

        while (node.left != null)
            node = node.left;

        return node;
    }

    /* Function to print nodes in a given doubly linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        Node head = bintree2list(root);

        printList(head);
    }
}
