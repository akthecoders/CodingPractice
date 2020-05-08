// Sum of Nodes with Even-Valued Grandparent
public class P1315 {
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        helper(root, null, null);
        return sum;
    }

    public void helper(TreeNode root, TreeNode parent, TreeNode gParent) {
        if (root == null)
            return;
        if (gParent != null && gParent.val % 2 == 0) {
            sum += root.val;
        }
        helper(root.left, root, parent);
        helper(root.right, root, parent);
    }
}