//Sum Root to Leaf Numbers
public class P129 {
    class TreeNode {
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

    int total;

    public int sumNumbers(TreeNode root) {
        total = 0;
        if (root == null)
            return total;
        solve(root, 0);
        return total;
    }

    public void solve(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            num = 10 * num + root.val;
            total += num;
            num = num - root.val;
            num /= 10;
            return;
        }

        num = 10 * num + root.val;
        solve(root.left, num);
        solve(root.right, num);
        num = num - root.val;
        num /= 10;
    }
}