import java.util.HashMap;
import java.util.Map;

//Longest ZigZag Path in a Binary Tree
public class P1372 {
    private enum Direction {
        LEFT, RIGHT
    }

    private int maxPath = -1;

    public int longestZigZag(TreeNode root) {
        Map<TreeNode, Integer> leftCache = new HashMap<>();
        Map<TreeNode, Integer> rightCache = new HashMap<>();

        helper(root, leftCache, rightCache, Direction.LEFT);
        helper(root, rightCache, rightCache, Direction.RIGHT);

        return maxPath;
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> leftCache, Map<TreeNode, Integer> rightCache,
            Direction dir) {
        if (root == null)
            return 0;
        else if (dir == Direction.LEFT && leftCache.containsKey(root)) {
            return leftCache.get(root);
        } else if (dir == Direction.RIGHT && rightCache.containsKey(root)) {
            return rightCache.get(root);
        }

        int path1 = root.left == null ? 0 : 1 + helper(root.left, leftCache, rightCache, Direction.RIGHT);
        leftCache.put(root, path1);
        maxPath = Math.max(maxPath, path1);
        int path2 = root.right == null ? 0 : 1 + helper(root.right, leftCache, rightCache, Direction.LEFT);
        rightCache.put(root, path2);
        maxPath = Math.max(maxPath, path2);
        return Direction.RIGHT == dir ? path2 : path1;
    }
}