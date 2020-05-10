// Path sum II
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P113 {
    private int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<Integer> currList = new LinkedList<>();
        currList.addLast(root.val);
        dfs(currList, root, root.val, res);
        return res;
    }

    public void dfs(LinkedList<Integer> currList, TreeNode root, int sumSoFar, List<List<Integer>> res) {
        if (sumSoFar == sum && root.left == null && root.right == null) {
            List<Integer> subList = new ArrayList<>();
            subList.addAll(currList);
            res.add(subList);
            currList.removeLast();
            return;
        }
        if (root.left != null) {
            currList.addLast(root.left.val);
            dfs(currList, root.left, sumSoFar + root.left.val, res);
        }
        if (root.right != null) {
            currList.addLast(root.right.val);
            dfs(currList, root.right, sumSoFar + root.right.val, res);
        }
        currList.removeLast();
    }
}