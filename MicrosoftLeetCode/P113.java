import java.util.ArrayList;
import java.util.List;

//Path Sum II
public class P113 {
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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        solve(root, result, new ArrayList<>(), 0, sum);
        return result;
    }

    public void solve(TreeNode root, List<List<Integer>> result, List<Integer> curr, int sum, int target) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += root.val;
            if (sum == target) {
                curr.add(root.val);
                result.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
            }
            sum -= root.val;
            return;
        }

        sum += root.val;
        curr.add(root.val);
        solve(root.left, result, curr, sum, target);
        solve(root.right, result, curr, sum, target);
        curr.remove(curr.size() - 1);
        sum -= root.val;
    }
}