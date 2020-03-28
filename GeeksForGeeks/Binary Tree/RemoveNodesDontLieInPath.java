/**
 * RemoveNodesDontLieInPath
 */
public class RemoveNodesDontLieInPath {
    static int max(int l, int r) {
        return (l > r ? l : r);
    }

    // A Binary Tree Node
    static class Node {
        int data;
        Node left, right;
    };

    static class INT {
        int v;

        INT(int a) {
            v = a;
        }
    }

    // A utility function to create
    // a new Binary Tree node with
    // given data
    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return node;
    }

    // print the tree in LVR
    // (Inorder traversal) way.
    static void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);
        }
    }

    static Node prune(Node root, int k) {
        INT sum = new INT(0);
        return pruneUtil(root, k, sum);
    }

    public static Node pruneUtil(Node root, int k, INT sum) {
     if(root == null) {
         return null;
     }   

     INT lSum = new INT(sum.v + root.data);
     INT rSum = new INT(lSum.v);

     root.left = pruneUtil(root.left, k, lSum);
     root.right = pruneUtil(root.right, k, rSum);

     sum.v = max(lSum.v, rSum.v);
     if(sum.v < k) {
         root = null;
     }
     return root;
    }

    // Driver Code
    public static void main(String args[]) {
        int k = 45;
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.left.left.left = newNode(8);
        root.left.left.right = newNode(9);
        root.left.right.left = newNode(12);
        root.right.right.left = newNode(10);
        root.right.right.left.right = newNode(11);
        root.left.left.right.left = newNode(13);
        root.left.left.right.right = newNode(14);
        root.left.left.right.right.left = newNode(15);

        System.out.println("Tree before truncation\n");
        print(root);

        root = prune(root, k); // k is 45

        System.out.println("\n\nTree after truncation\n");
        print(root);
    }
}