//Design HashSet
public class P705 {
    class Node {
        final int key;
        Node next;
    
        Node(int k, Node n) {
            key = k;
            next = n;
        }
    }
    private final Node[] buckets = new Node[2096];

    /** Initialize your data structure here. */
    public P705() {
        
    }

    public void add(int key) {
        if (!contains(key)) {
            int id = id(key);
            buckets[id] = new Node(key, buckets[id]);
        }
    }

    public void remove(int key) {
        Node node = buckets[id(key)];
        if (node == null) {
            return;
        }

        if (node.key == key) {
            buckets[id(key)] = node.next;
        } else {
            while (node.next != null && node.next.key != key) {
                node = node.next;
            }
            if (node.next != null) {
                node.next = node.next.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        Node node = buckets[id(key)];
        while (node != null && node.key != key) {
            node = node.next;
        }
        return node != null;
    }

    private int id(int key) {
        return key * 31 % buckets.length;
    }
}