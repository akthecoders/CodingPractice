//Recover Binary Search Tree
public class P99 {
    TreeNode prev, first, last;
    public void recoverTree(TreeNode root) {
        first = null;
        prev = null;
        last = null;
        fixer(root);
        if (first == null) return;
        int tmp = first.val;
        first.val = last.val;
        last.val = tmp;
    }
    
    public void fixer(TreeNode root) {
        if(root != null) {
            fixer(root.left);
            if(prev != null && root.val < prev.val) {
                if(first == null) {
                    first = prev;
                    last = root;
                }
                else {
                    last = root;
                }
            }
            prev = root;
            fixer(root.right);
        }
    }
}