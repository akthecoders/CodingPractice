// Reverse Nodes in k-Group
// Revised
public class P25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;
        ListNode curr = head;
        ListNode startNode = null;
        ListNode endNode = null;
        ListNode res = null;
        int count = 1;
        while (curr != null) {
            if (startNode == null)
                startNode = curr;
            curr = curr.next;
            if (count == k) {
                if (res == null)
                    res = reverse(startNode, k);
                else
                    endNode.next = reverse(startNode, k);
                endNode = startNode;
                count = 0;
                startNode = null;
            }
            count++;
        }
        if (startNode != null)
            endNode.next = startNode;
        return res;
    }

    public ListNode reverse(ListNode start, int k) {
        if (start == null || start.next == null)
            return start;
        ListNode prev = start;
        ListNode curr = start.next;
        prev.next = null;
        while (--k > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}