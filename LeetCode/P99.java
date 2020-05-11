//Recover Binary Search Tree
public class P99 {
    TreeNode prev, first, middle, last;

    public void recoverTree(TreeNode root) {
        fixer(root);
        if (first != null && last != null) {
            int data = first.val;
            first.val = last.val;
            last.val = data;
        } else if (first != null && middle != null) {
            int data = first.val;
            first.val = middle.val;
            middle.val = data;
        }
    }

    public void fixer(TreeNode root) {
        if (root != null) {
            fixer(root.left);
            if (prev != null && root.val < prev.val) {
                if (first == null) {
                    first = prev;
                    prev = root;
                } else {
                    last = root;
                }
            }
            prev = root;
            fixer(root.right);
        }
    }
}