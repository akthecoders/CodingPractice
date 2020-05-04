// Remove Linked List Elements
public class P203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = head;
        while (node != null) {
            if (node.val == val) {
                if (node == head) {
                    head = head.next;
                } else if (node.next == null) {
                    prev.next = null;
                    node = node.next;
                } else {
                    node = node.next;
                    prev.next = prev.next.next;
                }
            } else {
                prev = node;
                node = node.next;
            }
        }
        return head;
    }
}