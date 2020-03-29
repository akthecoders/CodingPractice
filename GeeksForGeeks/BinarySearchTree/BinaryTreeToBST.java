import java.util.Arrays;

/**
 * BinaryTreeToBST
 */
public class BinaryTreeToBST {
    static class Node {
        int data;
        Node left = null, right = null;
        public Node(int key) {
            data = key;
        }
    }
    
    public static int inOrderStore[] = new int[5];
    public static int index = 0;
    public static int size = 5;

    public static void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            inOrderStore[(index++) % size] = root.data;
            inOrder(root.right);
        }
        return;
    }

    public static void storeInOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            root.data = inOrderStore[(index++) % size];
            inOrder(root.right);
        }
    }

    public static Node convert(Node root) {
        if(root == null) {
            return root;
        }
        inOrder(root);
        Arrays.sort(inOrderStore);
        index = 0;
        storeInOrder(root);
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);
        
        inOrder(root);
        for (int data : inOrderStore) {
            System.out.print(data + " ");
        }
        System.out.println();
        root = convert(root);
        index = 0;
        inOrder(root);
        for (int data : inOrderStore) {
            System.out.print(data + " ");
        }
        System.out.println();
        
    }
}