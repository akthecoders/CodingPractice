// Add Two Numbers
public class P2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (l1 != null && l2 != null) {
            int sum = curr.val + l1.val + l2.val;
            if (sum > 9) {
                sum = sum % 10;
                curr.next = new ListNode(1);
            } else {
                if (!(l1.next == null && l2.next == null)) {
                    curr.next = new ListNode(0);
                }
            }
            curr.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        if (curr == null) {
            return result;
        }

        while (l1 != null) {
            int sum = curr.val + l1.val;
            if (sum > 9) {
                sum = sum % 10;
                curr.next = new ListNode(1);
            } else {
                if (l1.next != null) {
                    curr.next = new ListNode(0);
                }
            }
            curr.val = sum;
            l1 = l1.next;
            curr = curr.next;
        }

        while (l2 != null) {
            int sum = curr.val + l2.val;
            if (sum > 9) {
                sum = sum % 10;
                curr.next = new ListNode(1);
            } else {
                if (l2.next != null) {
                    curr.next = new ListNode(0);
                }
            }
            curr.val = sum;
            l2 = l2.next;
            curr = curr.next;
        }
        return result;
    }
}

// Revision