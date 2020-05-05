// Search in a Binary Search Tree
public class P700 {
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
        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null) {
                return null;
            }
            if(root.val == val) {
                return root;
            }
            
            TreeNode res = searchBST(root.left, val);
            if( res == null){
                return searchBST(root.right, val);
            }
            return res;
        }
    }
}