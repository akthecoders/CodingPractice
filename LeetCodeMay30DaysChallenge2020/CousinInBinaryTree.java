//Cousins in Binary Tree
public class CousinInBinaryTree {
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
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean ans[] = new boolean[1];
        dfs(root, x, y, 0, ans);
        return ans[0];
    }

    public int dfs(TreeNode root, int x, int y, int level, boolean ans[]) {
        if (root == null)
            return -1;
        if (root.val == x || root.val == y)
            return level;
        int left = dfs(root.left, x, y, level + 1, ans);
        int right = dfs(root.right, x, y, level + 1, ans);
        if (left != -1 && right != -1) {
            if (left == right && left != level + 1)
                ans[0] = true;
            return -1;
        }
        return left == -1 ? right : left;
    }
}