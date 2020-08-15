//Linked List Cycle
public class P141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode ptr = head;
        ListNode fastPtr = head.next;
        while (fastPtr != ptr) {
            if (fastPtr == null || fastPtr.next == null)
                return false;

            ptr = ptr.next;
            fastPtr = fastPtr.next.next;
        }
        return true;
    }
}