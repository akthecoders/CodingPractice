// Sum of Root To Leaf Binary Numbers
import java.util.*;
public class P1022 {
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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        helper(root, list);
        return sum;
    }

    public void helper(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            convertAddBinary(list);
            list.remove(list.size() - 1);
        }

        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
        list.remove(list.size() - 1);
    }

    public void convertAddBinary(ArrayList<Integer> list) {
        int num = 0;
        int power = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int listNum = list.get(i);
            num = num + listNum * (int) Math.pow(2, power++);
        }
        sum += num;
    }
}