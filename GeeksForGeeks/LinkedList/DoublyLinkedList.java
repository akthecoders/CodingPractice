/**
 * DoublyLinkedList
 */
public class DoublyLinkedList {
    Node head = null;

    class Node {
        int data;
        Node next;
        Node prev;
        public Node(int d) {
            this.data = d;
            this.next = null;
            this.prev = null;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertAfter(int data, int after) {
        Node newNode = new Node(data);
        Node trv = head;
        while(trv != null) {
            if(trv.data == after) {
                break;
            }
            trv = trv.next;
        }
        newNode.next = trv.next;
        newNode.prev = trv;
        trv.next.prev = newNode;
        trv.next = newNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        Node trv = head;
        while(trv.next != null) {
            trv = trv.next;
        }
        trv.next = newNode;
        newNode.prev = trv;
    }

    public void printList() {
        Node trv = head;
        while(trv != null) {
            System.out.print(trv.data + " -> ");
            trv = trv.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.push(2);
        ll.printList();
        ll.push(0);
        ll.printList();
        ll.append(3);
        ll.printList();
        ll.append(4);
        ll.printList();
        ll.insertAfter(1, 0);
        ll.printList();
    }
}