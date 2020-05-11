import java.util.Stack;

//Recover a Tree From Preorder Traversal
public class P1028 {
    class Node {
        TreeNode tn;
        int depth;

        Node(TreeNode tn, int depth) {
            this.tn = tn;
            this.depth = depth;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        Stack<Node> stack = new Stack<>();
        int idx = 0;
        int len = S.length();
        TreeNode root = null;
        while (idx < len) {
            int depth = 0;
            while (idx < len && S.charAt(idx) == '-') {
                idx++;
                depth++;
            }
            int val = 0;
            while (idx < len && S.charAt(idx) != '-') {
                val = 10 * val + S.charAt(idx++) - '0';
            }
            TreeNode n = new TreeNode(val);
            if (root == null) {
                root = n;
                stack.push(new Node(root, depth));
                continue;
            }
            if (stack.peek().depth < depth) {
                stack.peek().tn.left = n;
            } else {
                while (stack.peek().depth >= depth) {
                    stack.pop();
                }
                stack.peek().tn.right = n;
                stack.pop();
            }
            stack.push(new Node(n, depth));
        }
        return root;
    }
}