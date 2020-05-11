// Binary Tree Cameras
public class P968 {
    public int minCameraCover(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int[] counter = new int[1];
        installCamera(root, counter);
        if (root.val == 0) {
            root.val = 1;
            counter[0]++;
        }
        if (root.val == 0) {
            root.val = 1;
            counter[0]++;
        }
        return counter[0];
    }

    public void installCamera(TreeNode root, int[] counter) {
        if (root == null)
            return;
        installCamera(root.left, counter);
        installCamera(root.right, counter);

        if (root.left != null && root.left.val == 1 || (root.right != null && root.right.val == 1)) {
            root.val = 2;
        }

        if (root.left != null && root.left.val == 0) {
            root.val = 1;
            root.left.val = 2;
            if (root.right != null && root.right.val == 0) {
                root.right.val = 2;
            }
            counter[0]++;
        }
        if (root.right != null && root.right.val == 0) {
            root.val = 1;
            root.right.val = 2;
            if (root.left != null && root.left.val == 0) {
                root.left.val = 2;
            }
            counter[0]++;
        }
    }
}