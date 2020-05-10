//Complete Binary Tree Inserter
import java.util.*;
public class P919 {
    List<TreeNode> list;

    public P919(TreeNode root) {
        list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            list.add(curr);
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        list.add(node);
        TreeNode parent = list.get((list.size() - 2) / 2);
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        return parent.val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }
}