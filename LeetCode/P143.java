//Reorder List
import java.util.*;
public class P143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        ListNode slow = head;
        ListNode fast = head.next;

        if (fast == null)
            return;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = null;
            stack.push(slow);
            slow = temp;
        }

        ListNode start = head;
        while (!stack.empty() && start != null) {
            ListNode temp = start.next;
            ListNode next = stack.pop();
            start.next = next;
            next.next = temp;
            start = temp;
        }
    }
}