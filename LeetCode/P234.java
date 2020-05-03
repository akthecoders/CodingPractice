//  Palindrome Linked List
public class P234 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddleOfLinkedList(head);

        middle = reverseList(middle);

        while (middle != null) {
            if (head.val != middle.val) {
                return false;
            }
            head = head.next;
            middle = middle.next;
        }

        return true;
    }

    public ListNode findMiddleOfLinkedList(ListNode head) {
        ListNode fast = head, slow = head;

        while (true) {
            if (fast == null) {
                return slow;
            }

            fast = fast.next;
            if (fast == null) {
                return slow.next; // ignore middle element of odd list
            }

            fast = fast.next;
            slow = slow.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null, current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}