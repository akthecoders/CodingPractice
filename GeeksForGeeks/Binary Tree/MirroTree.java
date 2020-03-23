/**
 * MirroTree
 */
public class MirroTree {
    static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        
        System.out.println("Mirror : " + isMirror(root));
    }

    public static boolean isMirror(Node root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 != null && root2 != null && root1.key == root2.key) {
            return (isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));
        }

        return false;
    }
}

class Node {
    int key;
    Node left, right;
    Node (int item) {
        key = item;
        left = null;
        right = null;
    }
}