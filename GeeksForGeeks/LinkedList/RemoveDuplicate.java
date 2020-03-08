/**
 * RemoveDuplicate
 */
public class RemoveDuplicate {

  public static void main(String[] args) {
    LinkedList<Integer> root = new LinkedList<>();
    root.append(0);
    root.append(1);
    root.append(2);
    root.append(3);
    root.append(3);
    root.printList();
    removeDuplicate(root.head);
    root.printList();
  }

  public static void removeDuplicate(Node<Integer> head) {
    if(head == null) {
      return;
    }
    if(head.next != null) {
      if(head.data == head.next.data) {
        head.next = head.next.next;
        removeDuplicate(head);
      }
      else {
        removeDuplicate(head.next);
      }
    }
  }
}