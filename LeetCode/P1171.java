// Remove Zero Sum Consecutive Nodes from Linked List
public class P1171 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null)
            return head;
        ListNode current = head;
        int sum = head.val;
        while (sum != 0 && current.next != null) {
            current = current.next;
            sum += current.val;
        }
        if (sum == 0) {
            return removeZeroSumSublists(current.next);
        } else {
            head.next = removeZeroSumSublists(head.next);
            return head;
        }
    }
}