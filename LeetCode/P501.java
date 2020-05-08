//Find Mode in Binary Search Tree
import java.util.*;
public class P501 {
    private int max;

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        max = Integer.MIN_VALUE;
        preorder(root, counts);

        List<Integer> modes = new ArrayList<Integer>();
        for (int key : counts.keySet()) {
            if (counts.get(key) == max)
                modes.add(key);
        }

        int N = modes.size();
        int[] result = new int[N];
        int i = 0;
        for (int x : modes) {
            result[i++] = x;
        }

        return result;
    }

    private void preorder(TreeNode node, HashMap<Integer, Integer> counts) {
        if (node != null) {
            int count = counts.getOrDefault(node.val, 0);
            ++count;
            if (count > max)
                max = count;

            counts.put(node.val, count);
            preorder(node.left, counts);
            preorder(node.right, counts);
        }
    }
}