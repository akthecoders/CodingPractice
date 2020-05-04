// Sort List
public class P148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    private ListNode merge(ListNode head, ListNode head1) {
        ListNode sudoHead = new ListNode(0);
        ListNode temp = sudoHead;

        while (head != null && head1 != null) {
            if (head.val > head1.val) {
                System.out.println(" val 1 " + head1.val);
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
                temp.next = null;
            } else {
                System.out.println(" val 2 " + head.val);
                temp.next = head;
                head = head.next;
                temp = temp.next;
                temp.next = null;
            }
        }

        while (head != null) {
            temp.next = head;
            head = head.next;
            temp = temp.next;
            temp.next = null;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
            temp.next = null;
        }
        return sudoHead.next;
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && slow != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        /* after this slow will point to start of the list2 and fast at end */
        /* temp will be end of list1 and head will be the start of the list */

        temp.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);

    }
}