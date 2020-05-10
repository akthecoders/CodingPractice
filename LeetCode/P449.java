//Serialize and Deserialize BST
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class P449 {
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        String delim = "-";
        String res = list.stream().map(Object::toString).collect(Collectors.joining(delim));
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String str[] = data.split("-");
        int size = str.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        TreeNode root = null;
        for (int x : arr) {
            root = build(root, x);
        }
        return root;
    }

    public TreeNode build(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val <= root.val)
            root.left = build(root.left, val);
        else if (val > root.val)
            root.right = build(root.right, val);
        return root;
    }
}