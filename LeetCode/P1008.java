// Construct Binary Search Tree from Preorder Traversal

public class P1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end) {
        if (start > end)
            return null;

        TreeNode root = new TreeNode(preorder[start]);
        int index = findNextMax(preorder, start, end);
        if (index == -1) {
            root.left = helper(preorder, start + 1, end);
            root.right = null;
            return root;
        }
        root.left = helper(preorder, start + 1, index - 1);
        root.right = helper(preorder, index, end);
        return root;
    }

    public int findNextMax(int[] preorder, int given, int end) {
        int g = preorder[given];
        for (int i = given; i <= end; i++) {
            if (preorder[i] > g) {
                return i;
            }
        }
        return -1;
    }
}
