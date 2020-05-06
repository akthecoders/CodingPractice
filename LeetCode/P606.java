// Construct String from Binary Tree
public class P606 {
    public class TreeNode {
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

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String str = "" + t.val;
        if (t.left != null) {
            String s1 = tree2str(t.left);
            str += "(" + s1 + ")";
        }
        if (t.right != null) {
            String s2 = tree2str(t.right);
            str += "(" + s2 + ")";
        }
        return str;
    }
}