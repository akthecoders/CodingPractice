//Binary Tree Coloring Game
public class P1145 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode first = find(root, x);
        int left = size(first.left);
        int right = size(first.right);
        
        int max = Math.max(n - left - right - 1, Math.max(left, right));
        if(max >= (n/2) + 1) {
            return true;
        }
        return false;
    }
    
    public int size(TreeNode root) {
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }
    
    public TreeNode find(TreeNode root, int x) {
        if(root == null) return null;
        if(root.val == x) return root;
        TreeNode left = find(root.left, x);
        TreeNode right = find(root.right, x);
        if(left != null)    return left;
        if(right != null)   return right;
        return null;
    }
}