//Maximum Product of Splitted Binary Tree
import java.util.HashMap;

public class P1339 {
    private long total = 0, max = Long.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        max = Long.MIN_VALUE;
        HashMap<TreeNode, Long> sumCache = new HashMap<>();
        total = getCacheTotal(root, sumCache);
        getMax(root, sumCache);
        return (int) (max % 1000000007);
    }

    public void getMax(TreeNode root, HashMap<TreeNode, Long> sumCache) {
        if (root == null)
            return;

        if (root.left != null) {
            long sum1 = sumCache.get(root.left);
            long sum2 = total - sum1;
            long product = sum1 * sum2;
            max = Math.max(max, product);
        }
        if (root.right != null) {
            long sum1 = sumCache.get(root.right);
            long sum2 = total - sum1;
            long product = sum1 * sum2;
            max = Math.max(max, product);
        }
        getMax(root.left, sumCache);
        getMax(root.right, sumCache);
    }

    public long getCacheTotal(TreeNode root, HashMap<TreeNode, Long> sumCache) {
        if (root == null)
            return 0;
        long left = getCacheTotal(root.left, sumCache);
        long right = getCacheTotal(root.right, sumCache);

        long totalSum = root.val + left + right;
        sumCache.put(root, totalSum);
        return totalSum;
    }
}