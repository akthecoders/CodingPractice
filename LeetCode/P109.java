// Convert Sorted List to Binary Search Tree
import java.util.*;
public class P109 {
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

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nodes = parseToArray(head);
        return helper(nodes);
    }

    public TreeNode helper(List<Integer> nodes) {
        if (nodes.size() == 0) {
            return null;
        }
        int half = nodes.size() / 2;
        TreeNode root = new TreeNode(nodes.get(half));
        root.left = helper(nodes.subList(0, half));
        root.right = helper(nodes.subList(half + 1, nodes.size()));

        return root;
    }

    public List<Integer> parseToArray(ListNode head) {
        List<Integer> a = new ArrayList<>();
        while (head != null) {
            a.add(head.val);
            head = head.next;
        }
        return a;
    }
}