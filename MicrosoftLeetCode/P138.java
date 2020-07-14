//Copy List with Random Pointer
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
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node root = head;
        while (root != null) {
            Node newNode = new Node(root.val);
            newNode.next = root.next;
            root.next = newNode;
            root = newNode.next;
        }
        root = head;
        while (root != null) {
            root.next.random = (root.random != null) ? root.random.next : null;
            root = root.next.next;
        }

        Node oldList = head;
        Node newList = head.next;
        Node headOld = head.next;

        while (oldList != null) {
            oldList.next = oldList.next.next;
            newList.next = (newList.next != null) ? newList.next.next : null;
            oldList = oldList.next;
            newList = newList.next;
        }
        return headOld;
    }
}