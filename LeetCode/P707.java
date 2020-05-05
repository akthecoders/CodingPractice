// Design Linked List
public class P707 {
    // Create class for node
    class Node1 {
        // Create a public variables for the class
        public Node1 next;
        public int data;

        // Create a constructor for the class
        public Node1(int newData, Node1 link) {
            next = link;
            data = newData;
        }
    }

    // Create private variables for the class
    private Node1 head;
    private Node1 tail;
    public int length;

/** Initialize your data structure here. */
public P707() 
{
    head=null;
    tail=null;
    length=0;
}

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        // If list is empty is empty
        if (length == 0 || index >= length) {
            return -1;
        }
        // If the list is not empty and index is 0
        else if (length != 0 && index == 0) {
            return head.data;
        }
        // If the node is last node
        else if (length != 0 && index == (length - 1)) {
            return tail.data;
        }
        // If the node is somewhere between
        else {
            // Create a temp node variable
            Node1 temp = head;
            // Create a for loop that will traverse the linked list
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            return temp.data;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int newData) {
        // Create a new node first
        Node1 newNode = new Node1(newData, null);

        // If the list is empty
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        // If the list has nodes in it then
        else {
            newNode.next = head;
            head = newNode;
        }
        length = length + 1;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int newData) {
        Node1 newNode = new Node1(newData, null);
        // If the list is empty
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        // If is not empty
        else {
            tail.next = newNode;
            tail = newNode;
        }
        length = length + 1;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int newData) {
        // If the is either empty or if the index is at 0
        if ((length == 0 || index == 0)) {
            addAtHead(newData);
        }
        // If the index is equal to length then add the node at tail
        else if (length != 0 && index == length) {
            addAtTail(newData);
        }
        // If the is between the length
        else if (index < length) {
            // Create a new Node with the data
            Node1 newNode = new Node1(newData, null);
            // Create a temp node pointer
            Node1 temp = head;
            // Create a for loop that will go till index-1
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            length = length + 1;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // If want to delete first node
        if (length != 0 && index == 0) {
            head = head.next;
            length = length - 1;
        }
        // If we want to delete any other node
        else if (length != 0 && index < length && index > 0) {
            // Create two node pointers
            Node1 currentNode = head;
            Node1 prevNode = null;

            for (int i = 0; i < index; i++) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            // If the node to delete is the last one
            if (index == length - 1) {
                tail = prevNode;
                prevNode.next = currentNode.next;
            }
            // If the node is not the last one
            else {
                prevNode.next = currentNode.next;
            }
            length = length - 1;
        }
    }
}