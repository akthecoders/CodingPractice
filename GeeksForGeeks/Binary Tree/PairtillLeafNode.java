import java.util.HashSet;

/**
 * PairtillLeafNode
 */
public class PairtillLeafNode {
    static class Node {
        int data;
        Node left, right;
    };

    /*
     * utility that allocates a new node with the given data and null left and right
     * pointers.
     */
    static Node newnode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    static boolean isPathSum(Node root) {

        // create an empty hash table
        HashSet<Integer> s = new HashSet<Integer>();

        // Recursively check in left and right subtrees.
        return printPathUtil(root.left, s, root.data) || printPathUtil(root.right, s, root.data);
    }

    public static boolean printPathUtil(Node root, HashSet<Integer> s, int root_data) {
        if(root == null) {
            return false;
        }
        int rem = root_data - root.data;
        if(s.contains(rem)) {
            return true;
        }
        
        s.add(root.data);

        boolean res = printPathUtil(root.left, s, root_data) || printPathUtil(root.right, s, root_data);
        s.remove(root.data);
        return res;
    }

    public static void main(String[] args) {
        Node root = newnode(8);
        root.left = newnode(5);
        root.right = newnode(4);
        root.left.left = newnode(9);
        root.left.right = newnode(7);
        root.left.right.left = newnode(1);
        root.left.right.right = newnode(12);
        root.left.right.right.right = newnode(2);
        root.right.right = newnode(11);
        root.right.right.left = newnode(3);
        System.out.print(isPathSum(root) == true ? "Yes" : "No");
    }
}