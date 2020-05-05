// Increasing Order Search Tree
public class P897 {
    public class TreeNode {
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
    TreeNode head = null;
    TreeNode curr = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        increasingBST(root.left);
        if(curr != null) {
            curr.right = root;
            curr.left = null;
            curr = curr.right;
        }
        else {
            curr = root;
            head = curr;
        }
        increasingBST(root.right);
        return head;
    }
}