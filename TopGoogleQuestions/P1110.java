import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Delete Nodes And Return Forest
public class P1110 {
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

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> remaining = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for (int i : to_delete)
            toDelete.add(i);
        if (root == null)
            return remaining;
        removeNodes(root, toDelete, remaining);
        if (!toDelete.contains(root.val)) {
            remaining.add(root);
        }
        return remaining;
    }

    public TreeNode removeNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> remaining) {
        if (root == null) {
            return null;
        }

        root.left = removeNodes(root.left, toDelete, remaining);
        root.right = removeNodes(root.right, toDelete, remaining);

        if (toDelete.contains(root.val)) {
            if (root.left != null) {
                remaining.add(root.left);
            }
            if (root.right != null) {
                remaining.add(root.right);
            }
            return null;
        }
        return root;
    }
}
