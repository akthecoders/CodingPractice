//Diameter of Binary Tree
public class P543 {
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

    int max = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        resolve(root);
        return max - 1;
    }

    public int resolve(TreeNode root) {
        if (root == null)
            return 0;

        int leftSize = resolve(root.left);
        int rightSize = resolve(root.right);

        max = Math.max(max, leftSize + rightSize + 1);

        return Math.max(leftSize, rightSize) + 1;
    }
}