// Swap Nodes in Pairs
public class P24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp1 = head.next.next;
        ListNode tmp = head;
        head = head.next;
        head.next = tmp;
        head.next.next = swapPairs(temp1);
        return head;
    }
}