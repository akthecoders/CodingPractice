/**
 * InsertionInSortedCircularLL
 */
public class InsertionInSortedCircularLL {

    static class Node {
        Node next;
        int data;
    }

    static Node create() {
        Node newNode = new Node();
        newNode.next = null;
        return newNode;
    }

    static Node findHead(Node random) {
        if (random == null) {
            return null;
        }

        Node var = random;
        while (!(var.data > var.next.data || var.next == random)) {
            var = var.next;
        }
        return var.next;
    }

    static Node sortedInsert(Node head, Node newNode) {
        Node current = head;
        if (current == null) {
            newNode.next = newNode;
            head = newNode;
        } else if (current.data >= newNode.data) {
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            while (current.next != head && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        return head;
    }

    static void printList(Node start) {
        Node temp;
        if (start != null) {
            temp = start;
            do {
                System.out.println(temp.data + " ");
                temp = temp.next;
            } while (temp != start);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 56, 2, 11, 1, 90 };
        int i;
        Node start = null;
        Node temp;
        for (i = 0; i < 6; i++) {
            if (start != null)
                for (int j = 0; j < (Math.random() * 10); j++)
                    start = start.next;

            temp = create();
            temp.data = arr[i];
            start = sortedInsert(findHead(start), temp);
        }
        printList(findHead(start));
    }
}