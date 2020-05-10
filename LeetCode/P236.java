//Lowest Common Ancestor of a Binary Tree
public class P236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p.val, q.val);
    }
    
    public TreeNode helper(TreeNode root, int p, int q) {
        if(root == null) return null;
        if(root.val == p || root.val == q) {
            return root;
        }
        
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if(left != null && right != null) return root;
        
        if(left == null) return right;
        if(right == null) return left;
        return null;
    }
}