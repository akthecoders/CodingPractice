// Partition List
public class P86 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode r1 = l1;
        ListNode r2 = l2;
        while (head != null) {
            if (head.val < x) {
                l1.next = new ListNode(head.val);
                l1 = l1.next;
                head = head.next;
            } else {
                l2.next = new ListNode(head.val);
                l2 = l2.next;
                head = head.next;
            }
        }

        r1 = r1.next;
        r2 = r2.next;
        if (r1 == null && r2 == null)
            return null;
        if (r1 == null) {
            return r2;
        } else if (r2 == null) {
            return r1;
        }

        l1.next = r2;

        return r1;
    }
}