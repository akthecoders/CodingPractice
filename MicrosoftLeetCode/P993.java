//Cousins in Binary Tree
public class P993 {
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

    int recordDepth = -1;
    boolean isCousin = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        isCousins(root, 0, x, y);
        return this.isCousin;
    }

    public boolean isCousins(TreeNode node, int depth, int x, int y) {
        if (node == null) {
            return false;
        }
        if (this.recordDepth != -1 && depth > this.recordDepth) {
            return false;
        }
        if (node.val == x || node.val == y) {
            if (this.recordDepth == -1) {
                this.recordDepth = depth;
            }
            return this.recordDepth == depth;
        }

        boolean left = isCousins(node.left, depth + 1, x, y);
        boolean right = isCousins(node.right, depth + 1, x, y);

        if (left && right && this.recordDepth != depth + 1) {
            this.isCousin = true;
        }
        return left || right;

    }
}