import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * LevelOrderTraversalWithDirectionChange
 */
public class LevelOrderTraversalWithDirectionChange {

    static class Node {
        Node left;
        int data;
        Node right;
    };

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    // Driver Code
    public static void main(String[] args) {
        // Let us create binary tree
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.left.left.left = newNode(8);
        root.left.left.right = newNode(9);
        root.left.right.left = newNode(3);
        root.left.right.right = newNode(1);
        root.right.left.left = newNode(4);
        root.right.left.right = newNode(2);
        root.right.right.left = newNode(7);
        root.right.right.right = newNode(2);
        root.left.right.left.left = newNode(16);
        root.left.right.left.right = newNode(17);
        root.right.left.right.left = newNode(18);
        root.right.right.left.right = newNode(19);

        modifiedLevelOrder(root);
    }

    public static void modifiedLevelOrder(Node root) {
        if(root ==  null) {
            return;
        }

        if(root.left == null && root.right == null) {
            System.out.println(root.data);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        Stack<Node> st = new Stack<>();

        q.add(root);
        int ct = 0;
        int sz = 0;
        boolean rtl = false;
        Node tmp;
        while(!q.isEmpty()) {
            sz = q.size();
            ct++;
            for(int i = 0; i < sz; i++) {
                tmp = q.peek();
                q.remove();
                if(!rtl) {
                    System.out.print(tmp.data + " ");
                }
                else {
                    st.push(tmp);
                }
                if(tmp.left != null) {
                    q.add(tmp.left);
                }
                if(tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            if(rtl) {
                while(!st.isEmpty()) {
                    tmp = st.peek();
                    st.pop();
                    System.out.print(tmp.data + " ");
                }
            }
            if(ct == 2) {
                ct = 0;
                rtl = !rtl;
            }
            System.out.println();
        }

    }
}