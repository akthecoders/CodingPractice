/**
 * DeleteEveryKNode
 */
public class DeleteEveryKNode {

    public static void main(String[] args) {
        LinkedList<Integer> root = new LinkedList<>();
        root.append(0);
        root.append(1);
        root.append(2);
        root.append(3);
        root.append(4);   
        root.head.next.next.next.next.next = root.head;
        root.head = deleteEveryKthNode(root.head, 2);
    }

    public static Node<Integer> deleteEveryKthNode(Node<Integer> head_ref, int k) {
        Node<Integer> head = head_ref;
        Node<Integer> tmp = head;
        Node<Integer> tmp2 = head;
        Node<Integer> prev = head;

        int counter = 0;
        while(true) {
            if(tmp2 == head && tmp2.next == head) break;
            
            counter = 0;
            printList(head_ref);
            while(counter < k) {
                prev = tmp2;
                tmp2 = tmp2.next;
                counter++;
            }
            if(tmp2 == head) {
                prev = head;
                while(prev.next != head) {
                    prev = prev.next;
                }
                head = tmp2.next;
                prev.next = head;
                head_ref = head;
            }
            else if(tmp2.next == tmp) {
                prev.next = head;
            }
            else {
                prev.next = tmp2.next;
            }
        }
        return head;
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