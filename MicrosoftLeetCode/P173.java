import java.util.Stack;

//Binary Search Tree Iterator
public class P173 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    Stack<TreeNode> stack;

    public P173(TreeNode root) {
        stack = new Stack<>();
        this.leftMostInorder(root);
    }

    public void leftMostInorder(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode topNode = stack.pop();
        if (topNode.right != null) {
            this.leftMostInorder(topNode.right);
        }
        return topNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}