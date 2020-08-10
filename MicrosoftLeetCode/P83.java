//Remove Duplicates from Sorted List
public class P83 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode root = head.next;

        ListNode prev = head;
        while (root != null) {
            if (prev.val == root.val) {
                prev.next = root.next;
                root = prev.next;
            } else {
                prev = root;
                root = root.next;
            }
        }

        return head;
    }
}