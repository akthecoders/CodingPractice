//Reverse Nodes in k-Group
public class P25 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = head;
        ListNode ktail = null;

        ListNode newHead = null;

        while (root != null) {
            int count = 0;
            root = head;
            while (count < k && root != null) {
                root = root.next;
                count++;
            }

            if (count == k) {
                ListNode revHead = reverse(head, k);
                if (newHead == null) {
                    newHead = revHead;
                }
                if (ktail != null) {
                    ktail.next = revHead;
                }

                ktail = head;
                head = root;
            }
        }
        if (ktail != null) {
            ktail.next = head;
        }
        return newHead == null ? head : newHead;
    }

    public ListNode reverse(ListNode startNode, int k) {
        ListNode prev = null;
        ListNode root = startNode;
        ListNode next = null;

        while (k > 0) {
            next = root.next;
            root.next = prev;
            prev = root;
            root = next;
            k--;
        }
        return prev;
    }
}