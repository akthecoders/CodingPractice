import java.util.LinkedList;

// Find Bottom Left Tree Value
public class P513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return -1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int ans = root.val;

        while (queue.size() != 0) {
            int size = queue.size();
            boolean flag = false;

            while (size-- > 0) {
                TreeNode node = queue.removeFirst();
                if (node.left == null && node.right == null) {
                    if (flag == false) {
                        ans = node.val;
                        flag = true;
                    }
                }
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            }
        }
        return ans;
    }
}