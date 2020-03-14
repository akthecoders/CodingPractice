/**
 * SplittingNNodes
 */
public class SplittingNNodes {
    static Node<Integer> root = new Node<>(1);
    public static void main(String[] args) {
       root.next = new Node<Integer>(2);
       root.next.next = new Node<Integer>(3);
       root.next.next.next = new Node<Integer>(4);
       root.next.next.next.next = new Node<Integer>(5);
       root.next.next.next.next.next = new Node<Integer>(6);
       root.next.next.next.next.next.next = new Node<Integer>(7);
       root.next.next.next.next.next.next.next = root;
    
       Node<Integer> newList = splitList(3);
       printList(newList);
       printList(root);
    }

    public static Node<Integer> splitList(int n) {
        Node<Integer> newHead = null;
        Node<Integer> ptr = newHead;
        Node<Integer> ptr2 = root;
        for(int i = 0; i < n; i++) {
            Node<Integer> tNode = new Node<>(ptr2.data);
            if(newHead == null) {
                newHead = tNode;
                ptr = tNode;
            }
            else {
                ptr.next = tNode;
                ptr = ptr.next;
            }
            ptr2 = ptr2.next;
        }
        ptr.next = newHead;

        ptr = root; 
        root = ptr2;
        
        while(ptr2.next != ptr) {
            ptr2 = ptr2.next;
        }
        ptr2.next = root;
        return newHead;
    } 

    public static void printList(Node<Integer> head) {
        Node<Integer> tmp = head;
        do {
            System.out.print(tmp.data + ", ");
            tmp = tmp.next;
        } while( tmp != head);
        System.out.println();
    }

}