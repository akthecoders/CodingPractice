// Binary Tree Paths
import java.util.*;
public class P257 {
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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        return traverse(root, "", new ArrayList<String>());
    }

    public static List<String> traverse(TreeNode node, String str, List<String> list) {
        str += Integer.toString(node.val);
        str += "->";
        if (node.left == null && node.right == null) {
            str = str.substring(0, str.length() - 2);
            list.add(str);
        }

        if (node.left != null)
            traverse(node.left, str, list);

        if (node.right != null)
            traverse(node.right, str, list);

        return list;
    }
}