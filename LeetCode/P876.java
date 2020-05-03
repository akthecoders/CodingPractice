// Middle of the Linked List
public class P876 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode middleNode(ListNode head) {
        ListNode fastNode = head;
        ListNode node = head;
        while(fastNode != null) {
            fastNode = fastNode.next;
            if(fastNode == null) {
                break;
            }
            fastNode = fastNode.next;
            node = node.next;
            
        }
        return node;
    }
}