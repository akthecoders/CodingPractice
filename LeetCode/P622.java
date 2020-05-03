// Design Circular Queue
public class P622 {
    int queue[];
    int head = -1;
    int tail = 0;
    int capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public P622(int k) {
        queue = new int[k];
        capacity = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail++] = value;
        if (head == -1) {
            head = 0;
        }
        if (tail == capacity) {
            tail = 0;
        }
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head++;
        if (head == capacity) {
            head = 0;
        }
        if (head == tail) {
            head = -1;
            tail = 0;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return queue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = tail - 1;
        if (index == -1) {
            index = capacity - 1;
        }
        return queue[index];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return head == tail;
    }
}