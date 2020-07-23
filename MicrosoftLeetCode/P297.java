//Serialize and Deserialize Binary Tree
public class P297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int pos = 0;

    public String serial(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = serial(root.left, str);
            str = serial(root.right, str);
        }
        return str;
    }

    public TreeNode deserial(String[] str) {
        if (pos == str.length)
            return null;
        if (str[pos].equals("null")) {
            pos++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(str[pos]));
        pos++;
        root.left = deserial(str);
        root.right = deserial(str);
        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        return serial(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String split[] = data.split(",");
        return deserial(split);
    }
}