// Merge Two Sorted Lists
public class P21 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null & l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode root = null;
        if (l1.val < l2.val) {
            root = l1;
            l1 = l1.next;
        } else {
            root = l2;
            l2 = l2.next;
        }
        ListNode mergeRoot = root;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                mergeRoot.next = l1;
                l1 = l1.next;
            } else {
                mergeRoot.next = l2;
                l2 = l2.next;
            }
            mergeRoot = mergeRoot.next;
        }

        while (l1 != null) {
            mergeRoot.next = l1;
            l1 = l1.next;
            mergeRoot = mergeRoot.next;
        }

        while (l2 != null) {
            mergeRoot.next = l2;
            l2 = l2.next;
            mergeRoot = mergeRoot.next;
        }
        return root;
    }
}