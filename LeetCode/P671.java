// Second Minimum Node In a Binary Tree
public class P671 {
    int min = -1;
    int secondMin = -1;

    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        return secondMin;
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;
        if (min == -1 || root.val < min) {
            secondMin = min;
            min = root.val;
        } else if (root.val != min && (secondMin == -1 || root.val < secondMin)) {
            secondMin = root.val;
        }
        helper(root.left);
        helper(root.right);
    }
}