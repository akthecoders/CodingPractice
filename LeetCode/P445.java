// Add Two Numbers II
public class P445 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode curr = new ListNode();
        ListNode head = curr;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + curr.val;
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            curr.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 != null)
                l1 = new ListNode();

            else if (l1 != null && l2 == null)
                l2 = new ListNode();

            if ((l1 != null && l2 != null) || carry != 0)
                curr.next = new ListNode(carry);
            curr = curr.next;
        }

        return reverse(head);
    }

    public ListNode reverse(ListNode root) {
        if (root == null || root.next == null)
            return root;

        ListNode next = null;
        ListNode prev = null;
        ListNode current = root;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}