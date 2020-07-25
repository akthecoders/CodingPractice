//Construct Binary Tree from Preorder and Inorder Traversal
public class P109 {
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
    int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        return solver(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode solver(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (pre >= preorder.length) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(preorder[pre++]);
        }
        TreeNode root = new TreeNode(preorder[pre]);
        int pos = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[pre]) {
                pos = i;
                break;
            }
        }
        pre++;
        if (pos > inStart && pos < inEnd) {
            root.left = solver(preorder, inorder, inStart, pos - 1);
            root.right = solver(preorder, inorder, pos + 1, inEnd);
        } else if (pos == inStart) {
            root.right = solver(preorder, inorder, pos + 1, inEnd);
        } else if (pos == inEnd) {
            root.left = solver(preorder, inorder, inStart, pos - 1);
        }
        return root;
    }
}