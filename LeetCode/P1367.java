// Linked List in Binary Tree
import java.util.*;
public class P1367 {

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
    ArrayList<String> list = new ArrayList<>();

    public boolean isSubPath(ListNode head, TreeNode root) {
        ListNode iter = head;
        String str = "";
        while (iter != null) {
            str += iter.val + ",";
            iter = iter.next;
        }
        leafPath(root, "");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (list.get(i).contains(str))
                return true;
        }
        return false;
    }

    public void leafPath(TreeNode root, String str) {
        if (root == null) {
            list.add(str);
            str = "";
            return;
        }
        str += "" + root.val + ",";
        leafPath(root.left, str);
        leafPath(root.right, str);
    }
}