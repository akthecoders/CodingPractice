import java.util.ArrayList;
import java.util.List;

//Unique Binary Search Trees II
public class P95 {
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (n == 0)
            return list;
        return helper(1, n);
    }

    public ArrayList<TreeNode> helper(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> left = helper(start, i - 1);
            ArrayList<TreeNode> right = helper(i + 1, end);

            for (int j = 0; j < left.size(); j++) {
                TreeNode L = left.get(j);
                for (int k = 0; k < right.size(); k++) {
                    TreeNode R = right.get(k);
                    TreeNode root = new TreeNode(i);
                    root.left = L;
                    root.right = R;
                    list.add(root);
                }
            }
        }
        return list;
    }
}