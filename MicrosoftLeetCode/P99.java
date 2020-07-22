//Recover Binary Search Tree
public class P99 {
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
    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null)
                            x = pred;
                    }
                    pred = root;
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null)
                        x = pred;
                }
                pred = root;
                root = root.right;
            }
        }
        swap(x, y);
    }
}