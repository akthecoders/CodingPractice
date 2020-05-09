//Maximum Difference Between Node and Ancestor
public class P1026 {
    int res = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        helper(root);
        return res;
    }

    public int[] helper(TreeNode root) {
        if (root == null)
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };

        int[] l = helper(root.left);
        int[] r = helper(root.right);

        int mini = Math.min(l[0], r[0]);
        int max = Math.max(l[1], r[1]);

        if (mini != Integer.MAX_VALUE)
            res = Math.max(res, Math.abs(root.val - mini));
        if (max != Integer.MIN_VALUE)
            res = Math.max(res, Math.abs(root.val - max));

        return new int[] { Math.min(root.val, mini), Math.max(root.val, max) };
    }
}