import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

//Serialize and Deserialize Binary Tree
public class P297 {
    public String serialize(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr == null) {
                    list.add("null");
                }
                else {
                    list.add(Integer.toString(curr.val));
                    q.add(curr.left);
                    q.add(curr.right);
                }
                
            }
        }
        String delim = ",";
        String res = list.stream().map(Object::toString).collect(Collectors.joining(delim));
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String str[] = data.split(",");
        if(str[0].compareTo("null") == 0) {
                return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        for(int i = 1; i < str.length; i++) {
            TreeNode curr = q.poll();
            String s1 = str[i];
            if(s1.compareTo("null") != 0) {
                curr.left = new TreeNode(Integer.parseInt(s1));
                q.add(curr.left);
            }
            i++;
            if(i < str.length) {
                String s2 = str[i];
                if(s2.compareTo("null") != 0) {
                    curr.right = new TreeNode(Integer.parseInt(s2));
                    q.add(curr.right);
                }
            }
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