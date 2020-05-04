// Flatten a Multilevel Doubly Linked List
public class P430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if (head == null)
            return head;
        Node pointer = head;
        dfs(pointer);
        return head;
    }

    private Node dfs(Node curr) {
        while (curr != null) {
            Node lastNode = curr;
            Node next = curr.next;
            if (curr.child != null) {
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                lastNode = dfs(curr.next);
            }
            if (next == null)
                return lastNode;
            lastNode.next = next;
            next.prev = lastNode;
            curr = next;
        }

        return curr;
    }
}