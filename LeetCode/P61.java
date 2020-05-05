// Rotate List
public class P61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        // Get LinkedList length
        while (current != null) {
            ++length;

            if (current.next == null) {
            }

            current = current.next;
        }

        if (length == 0 || length == 1) {
            return head;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        return rotateRight(head, length, k);
    }

    private ListNode rotateRight(ListNode head, int length, int k) {

        // First let's determine cut point
        int cutPointIndex = length - k;
        ListNode cutPoint = head;

        for (int i = 0; i < cutPointIndex - 1; ++i) {
            cutPoint = cutPoint.next;
        }

        // Get tail
        ListNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        ListNode tail = current.next;

        // Make new head the next of the cut point ...
        ListNode newHead = cutPoint.next;

        // Make next of tail, the old head ...
        tail.next = head;

        // Finally nullify cutpoint next to avoid circular referencing
        cutPoint.next = null;

        return newHead;
    }
}