import java.util.HashSet;
import java.util.Set;

// Linked List Components
public class P817 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int x : G) {
            set.add(x);
        }
        int components = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                components++;
                while (head != null && set.contains(head.val))
                    head = head.next;
            } else {
                head = head.next;
            }
        }
        return components;

    }
}