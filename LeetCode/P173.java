// Binary Search Tree Iterator
import java.util.*;

public class P173 {
    public class TreeNode {
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

    List<Integer> values = new ArrayList<>();
    int currentIndex = 0;

    public P173(TreeNode root) {
        treeInorderTraversal(root);
    }

    /** @return the next smallest number */
    public int next() {
        return values.get(currentIndex++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (currentIndex < values.size())
            return true;

        return false;
    }

    public void treeInorderTraversal(TreeNode root) {
        if (root == null)
            return;
        treeInorderTraversal(root.left);
        values.add(root.val);
        treeInorderTraversal(root.right);
    }
}