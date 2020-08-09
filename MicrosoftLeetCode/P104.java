
//Maximum Depth of Binary Tree
public class P104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int res = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return res;
        depth(root, 0);
        return res;
    }

    public void depth(TreeNode root, int depth) {
        if (root == null) {
            res = Math.max(res, depth);
            return;
        }

        depth(root.left, depth + 1);
        depth(root.right, depth + 1);
    }
}