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

    public static Node delete(Node root, int key) {
        if(root == null) {
            return root;
        }

        if(key < root.data) {
            root.left = delete(root.left, key);
        }
        else if(key > root.data) {
            root.right = delete(root.right, key);
        }
        else {
            if(root.left == null && root.right == null) {
                return null;
            }
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);

        }
        return root;
    }

    public static int minValue(Node root) {
        int minV = root.data;
        while(root.left != null) {
            minV = root.left.data;
            root = root.left;
        }
        return minV;
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
        root = insert(root, 8);
        traverse(root);
        System.out.println();
        root = insert(root, 9);
        traverse(root);
        System.out.println();
        root = delete(root, 6);
        traverse(root);
        System.out.println();
    }
}