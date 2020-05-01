// Binary Tree Preorder Traversal
import java.util.*;
public class P144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return output;

    }
}