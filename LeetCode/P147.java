// Insertion Sort List
public class P147 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode iter = head;
        while (iter.next != null) {
            ListNode temp = iter.next;
            ListNode iter2 = head;
            while (iter2 != null && temp.val > iter2.val) {
                iter2 = iter2.next;
            }
            int x = temp.val;
            int t1 = iter2.val;
            if (iter2.next == null)
                break;
            int t2 = iter2.next.val;
            ListNode change = iter2;
            while (iter2 != temp) {
                iter2.next.val = t1;
                t1 = t2;
                iter2 = iter2.next;
                if (iter2.next == null)
                    break;
                t2 = iter2.next.val;

            }
            change.val = x;
            iter = iter.next;
        }
        return head;
    }
}