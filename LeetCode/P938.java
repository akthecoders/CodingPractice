// Range Sum of BST
public class P938 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        int r = isInRange(root.val, L, R);
        if (r == 0) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (r == -1) {
            return rangeSumBST(root.right, L, R);
        } else if (r == 1) {
            return rangeSumBST(root.left, L, R);
        }
        return 0;
    }

    public int isInRange(int i, int L, int R) {
        if (i >= L && i <= R) {
            return 0;
        }
        if (i < L) {
            return -1;
        }
        return 1;
    }
}