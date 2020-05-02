
// Binary Tree Zigzag Level Order Traversal
import java.util.*;

public class P103 {
    class TreeNode {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> s = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        s.offer(root);
        boolean lR = true;
        while (!s.isEmpty()) {
            int size = s.size();
            List<Integer> t = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode pop = s.poll();

                if (lR) {
                    t.add(pop.val);
                } else {
                    t.add(0, pop.val);
                }
                if (pop.left != null)
                    s.offer(pop.left);
                if (pop.right != null)
                    s.offer(pop.right);
            }
            lR = !lR;
            list.add(t);
        }
        return list;
    }
}