// Remove Duplicates from Sorted List
import java.util.HashSet;
import java.util.Set;

public class P83 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        ListNode prev = node;
        while (node != null) {
            if (set.contains(node.val)) {
                node = node.next;
                prev.next = prev.next.next;
            } else {
                prev = node;
                set.add(node.val);
                node = node.next;
            }
        }

        return head;
    }
}