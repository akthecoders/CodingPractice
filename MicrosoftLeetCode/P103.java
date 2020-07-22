import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//Binary Tree Zigzag Level Order Traversal
public class P103 {
    class TreeNode {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<Integer> st = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (flag) {
                    t.add(curr.val);
                } else {
                    st.push(curr.val);
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            while (st.size() > 0) {
                t.add(st.pop());
            }
            result.add(t);
            flag = !flag;
        }
        return result;
    }
}