//Construct Binary Tree from Inorder and Postorder Traversal
public class P106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int i_left, int i_right, int p_left, int p_right) {
        if (p_left > p_right || i_left > i_right)
            return null;
        TreeNode root = new TreeNode(postorder[p_right]);
        int count = 0;
        for (int cur = i_left; cur <= i_right; cur++) {
            if (inorder[cur] == postorder[p_right])
                break;
            count++;
        }
        root.left = helper(inorder, postorder, i_left, i_left + count - 1, p_left, p_left + count - 1);
        root.right = helper(inorder, postorder, i_left + count + 1, i_right, p_left + count, p_right - 1);

        return root;
    }
}