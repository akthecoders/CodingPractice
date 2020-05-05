// Copy List with Random Pointer
import java.util.*;
public class P138 {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    HashMap<Node, Node> map;

    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        return clone(head);
    }

    public Node clone(Node head) {
        if (head == null)
            return null;

        if (map.containsKey(head))
            return map.get(head);

        Node copy = new Node(head.val);
        map.put(head, copy);
        copy.next = clone(head.next);
        copy.random = clone(head.random);
        return copy;
    }
}