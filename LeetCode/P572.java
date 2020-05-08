// Subtree of Another Tree
public class P572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            if (isSimilar(s, t)) {
                return true;
            }
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSimilar(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null)
            return false;
        if (t == null)
            return false;

        if (s.val != t.val)
            return false;
        return isSimilar(s.left, t.left) && isSimilar(s.right, t.right);
    }
}