import java.util.*;

//  Binary Tree Level Order Traversal II
public class P107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        TreeMap<Integer, List<Integer>> result = new TreeMap<>();

        traverse(root, 0, result);
        return new ArrayList<>(result.descendingMap().values());

    }

    private void traverse(TreeNode node, int level, Map<Integer, List<Integer>> result) {
        if (node == null) {
            return;
        } else {
            List<Integer> values = result.getOrDefault(level, new ArrayList<>());
            values.add(node.val);
            result.put(level, values);
            traverse(node.left, level + 1, result);
            traverse(node.right, level + 1, result);
        }
    }
}