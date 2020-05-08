//Find a Corresponding Node of a Binary Tree in a Clone of That Tree

public class P1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null)
            return null;
        if (original.val == target.val)
            return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if (left == null)
            return right;
        return left;
    }
}