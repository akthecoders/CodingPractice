// Merge k Sorted Lists
import java.util.*;
public class P23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (ListNode head : lists) {
            while (head != null) {
                heap.add(head.val);
                head = head.next;
            }
        }
        if (heap.isEmpty())
            return null;
        ListNode head = new ListNode(heap.poll());
        ListNode temp = head;

        while (!heap.isEmpty()) {
            ListNode t = new ListNode(heap.poll());
            temp.next = t;
            temp = temp.next;
        }
        return head;
    }
}