public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode oddEvenList(ListNode head) {
        boolean odd = true;
        int size = 0;
        ListNode root = head;
        ListNode tail = null;
        while (root != null) {
            tail = root;
            size++;
            root = root.next;
        }
        root = head;
        ListNode prev = null;
        for (int i = 0; i < size; i++) {
            if (odd) {
                prev = root;
                root = root.next;
                odd = !odd;
            } else {
                tail.next = root;
                tail = tail.next;
                prev.next = root.next;
                root = root.next;
                tail.next = null;
                odd = !odd;
            }
        }
        return head;
    }
}