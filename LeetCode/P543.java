//  Diameter of Binary Tree
public class P543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        nodeOnHeight(root);
        return ans;
    }
    
    public int nodeOnHeight(TreeNode root) {
        if(root == null) return 0;
        int L = nodeOnHeight(root.left);
        int R = nodeOnHeight(root.right);
        
        ans = Math.max(ans, L + R);
        return 1 + Math.max(L , R);
    }
}