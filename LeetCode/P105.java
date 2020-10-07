//Construct Binary Tree from Preorder and Inorder Traversal
// Revised
public class P105 {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int l, int r) {
        if (l > r)
            return null;

        int required = preorder[preIndex];
        preIndex++;
        int index = l;
        for (int i = l; i <= r; i++) {
            if (required == inorder[i]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(required);
        if (index <= r) {
            root.left = helper(preorder, inorder, l, index - 1);
            root.right = helper(preorder, inorder, index + 1, r);
        }
        return root;
    }
}