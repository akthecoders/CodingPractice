// Symmetric Tree
public class P101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode r1, TreeNode r2) {
        if(r1 == null || r2 == null) {
            return r1 == r2;
        }
        if(r1.val != r2.val) {
            return false;
        }
        return isSymmetric(r1.left, r2.right) && isSymmetric(r1.right, r2.left);
    }
}