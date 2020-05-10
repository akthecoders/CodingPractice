import java.util.LinkedList;
import java.util.Queue;

//Check Completeness of a Binary Tree
public class P958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    if (flag)
                        return false;
                    q.add(curr.left);
                } else {
                    flag = true;
                }

                if (curr.right != null) {
                    if (flag)
                        return false;
                    q.add(curr.right);
                } else {
                    flag = true;
                }
            }
        }
        return true;
    }
}