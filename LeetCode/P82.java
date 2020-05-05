// Remove Duplicates from Sorted List II
public class P82 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode pointer = null;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                int val = curr.val;
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }
            } else {
                if (pointer == null) {
                    head = curr;
                    pointer = curr;
                } else {
                    pointer.next = curr;
                    pointer = curr;
                }
                curr = curr.next;
            }
        }
        if (pointer != null) {
            pointer.next = null;
        } else {
            head = null;
        }

        return head;
    }
}