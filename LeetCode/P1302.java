import java.util.LinkedList;
import java.util.Queue;

//Deepest Leaves Sum
public class P1302 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            ans = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                ans += curr.val;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return ans;
    }
}