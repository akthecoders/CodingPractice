//Binary Tree Tilt
public class P563 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int sum = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }
    
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int L = helper(root.left);
        int R = helper(root.right);
        sum += Math.abs(L - R);
        return L + R + root.val;
    }
}