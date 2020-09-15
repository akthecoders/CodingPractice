//Add Two Numbers
public class P2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;

            ListNode newNode = new ListNode(sum);

            if (head == null) {
                head = newNode;
                curr = newNode;
                continue;
            }
            curr.next = newNode;
            curr = curr.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1.next;
            ListNode newNode = new ListNode(sum);
            if (head == null) {
                head = newNode;
                curr = newNode;
                continue;
            }
            curr.next = newNode;
            curr = curr.next;

        }

        while (l2 != null) {
            int sum = l2.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l2 = l2.next;
            ListNode newNode = new ListNode(sum);
            if (head == null) {
                head = newNode;
                curr = newNode;
                continue;
            }
            curr.next = newNode;
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head;
    }
}
