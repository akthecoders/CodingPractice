//Design Circular Queue
public class P622 {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int max;
    int cap;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public P622(int k) {
        head = null;
        tail = null;
        this.max = k;
        this.cap = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (cap >= this.max) {
            return false;
        }

        if (head == null) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            tail.next = head;
            cap++;
        } else {
            Node newNode = new Node(value);
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
            cap++;
        }
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (head == null)
            return false;

        if (head == tail) {
            head = null;
            tail = null;
            this.cap--;
        } else {
            tail.next = head.next;
            head = head.next;
            this.cap--;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (head == null)
            return -1;
        return head.val;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (tail == null)
            return -1;
        return tail.val;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return !(this.cap > 0);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.cap == this.max;
    }
}