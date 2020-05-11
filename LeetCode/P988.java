//Smallest String Starting From Leaf
public class P988 {
    String result = null;
    StringBuilder sb = new StringBuilder();

    public String smallestFromLeaf(TreeNode root) {
        recurse(root, sb);
        return result;
    }

    public void recurse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.insert(0, String.valueOf((char) (root.val + 97)));
        if (root.left == null && root.right == null) {
            if (result == null)
                result = sb.toString();
            else {
                System.out.println(sb.toString());
                if ((sb.toString()).compareTo(result) < 0) {
                    result = sb.toString();
                }
            }
            sb.delete(0, 1);
            return;
        }
        recurse(root.left, sb);
        recurse(root.right, sb);
        sb.delete(0, 1);
        return;
    }
}