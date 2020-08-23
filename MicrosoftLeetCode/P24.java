//Swap Nodes in Pairs
public class P24 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = null;

        if (curr != null)
            next = curr.next;

        curr.next = prev;
        head.next = swapPairs(next);
        return curr;
    }
}