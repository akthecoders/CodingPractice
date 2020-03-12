/**
 * DeleteOddNodes
 */
public class DeleteOddNodes {

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(2);
        head.next = new Node<Integer>(12);
        head.next.next = new Node<Integer>(11);
        head.next.next.next = new Node<Integer>(57);
        head.next.next.next.next = head;
        printList(head);
        deleteOddNodes(head);
        printList(head);
    }

    public static void deleteOddNodes(Node<Integer> head) {
        Node<Integer> temp = head.next;
        
        do {
            if((temp.data % 2) == 1) {
                if(head == temp) {
                    head = head.next;
                }
                else {
                    Node<Integer> tT = head;
                    while(tT.next != temp) {
                        tT = tT.next; 
                    }
                    tT.next = temp.next;
                }
            }
            temp = temp.next;
        } while(temp != head);
    }

    static void printList(Node<Integer> head) 
    { 
        Node<Integer> temp = head; 
        if (head != null) { 
            do { 
                System.out.printf("%d ", temp.data); 
                temp = temp.next; 
            } while (temp != head); 
        } 
        System.out.println();
    } 
}