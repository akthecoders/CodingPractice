import java.util.LinkedList;
import java.util.Queue;

/**
 * DeletionInTree
 */
public class DeletionInTree {
    static Node root;
    static Node temp;
    static class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }
        static void deleteNode(Node temp, int key) {
            Queue<Node> q = new LinkedList<>();
            Node toDelete = null, swapFrom  = null, tNode  = null;
            q.add(temp);
            while(!q.isEmpty()) {
                swapFrom = q.peek();
                tNode = q.peek();
                q.remove();
                if(tNode.key == key) {
                    toDelete = tNode;
                }
                if(tNode.left != null) {
                    q.add(tNode.left);
                }
                if(tNode.right != null) {
                    q.add(tNode.right);
                }
            }

            toDelete.key = swapFrom.key;
            swapFrom.key = 0;
            swapFrom = null;

        }

        static void inOrder(Node temp) {
            if(temp == null) {
                return;
            }
            inOrder(temp.left);
            System.out.print(temp.key + " ");
            inOrder(temp.right);
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

        int key = 7;
        deleteNode(root, key);

        System.out.print("\nInorder traversal after insertion:");
        inOrder(root);
    }
}