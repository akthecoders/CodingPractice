// Kth Smallest Element in a BST
public class P230 {
    int count = 0;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null)
            return;
        dfs(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }
}