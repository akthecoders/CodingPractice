// Split Linked List in Parts
public class P725 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k == 0)
            return null;
        int length = findLength(root);
        ListNode[] list = new ListNode[k];
        int parts = length / k == 0 ? 1 : length / k;
        int diff = length - parts * k;
        ListNode head = root, next = root, prev = root;
        int start = 0;
        int i = 0;
        while (next != null) {
            while (start < parts && next != null) {
                prev = next;
                next = next.next;
                start++;
            }

            if (diff > 0) {
                prev = next;
                next = next.next;
                diff--;
            }

            ListNode temp = next;
            prev.next = null;
            list[i++] = head;
            next = temp;
            head = temp;
            prev = temp;
            start = 0;
        }
        return list;
    }

    public int findLength(ListNode root) {
        ListNode tmp = root;
        int size = 0;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        return size;
    }
}