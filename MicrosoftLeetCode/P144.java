import java.util.ArrayList;
import java.util.List;

//Binary Tree Preorder Traversal
public class P144 {
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

    List<Integer> res;

    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if (root == null)
            return res;
        preOrder(root);
        return res;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}