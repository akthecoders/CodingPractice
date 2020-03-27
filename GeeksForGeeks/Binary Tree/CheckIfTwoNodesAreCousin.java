/**
 * CheckIfTwoNodesAreCousin
 */
public class CheckIfTwoNodesAreCousin {
    static class Node {
        int data;
        Node left = null, right = null;

        public Node(int key) {
            data = key;
        }
    }

    static Node root;
    static Node p1;
    static Node p2;
    static int gLevel = 0;

    public static boolean isCousin(Node root, Node n1, Node n2) {
        int level1 = findLevel(root, n1, 0);
        int level2 = findLevel(root, n2, 0);
        if(level1 == level2) {
            return !isSibling(root, n1, n2);
        }
        return false;
    }

    public static boolean isSibling(Node root, Node n1, Node n2) {
        if(root == null) {
            return false;
        }
        return (root.left == n1 && root.right == n2 || root.left == n2 && root.right == n1 || isSibling(root.left, n1, n2) || isSibling(root.right, n1, n2));
    }


    public static int findLevel(Node root, Node n1,int level) {
        if(root == null) {
            return 0;
        }
        
        if(root == n1) {
            return level;
        }

        int l = findLevel(root.left, n1, level + 1);
        if(l != 0) {
            return l;
        }
        return findLevel(root.right, n1, level + 1);
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        Node Node1, Node2;
        Node1 = root.left.left;
        Node2 = root.right.right;
        if (isCousin(root, Node1, Node2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}