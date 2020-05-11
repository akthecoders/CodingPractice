//Flip Binary Tree To Match Preorder Traversal
import java.util.ArrayList;
import java.util.List;

public class P971 {
    int pos = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        boolean isPossible = dfs(root, list, voyage);
        if (isPossible && pos >= voyage.length) {
            return list;
        }
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(-1);
        return ans;
    }

    public boolean dfs(TreeNode root, List<Integer> list, int[] v) {
        if (root == null)
            return true;
        if (v[pos] != root.val)
            return false;
        pos++;
        if (pos < v.length) {
            if (root.right != null && root.left != null) {
                if (v[pos] == root.right.val) {
                    TreeNode temp = root.right;
                    root.right = root.left;
                    root.left = temp;
                    list.add(root.val);
                }
            }
        }

        boolean left = dfs(root.left, list, v);
        boolean right = dfs(root.right, list, v);
        return left && right;
    }
}