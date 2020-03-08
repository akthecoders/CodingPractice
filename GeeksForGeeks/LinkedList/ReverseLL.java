/**
 * ReverseLL
 */
public class ReverseLL {

  public static void main(String[] args) {
    LinkedList<Integer> root = new LinkedList<>();
    root.append(0);
    root.append(1);
    root.append(2);
    root.append(3);
    root.printList();
    reverseLL(root);
    root.printList();
  }
  
  public static void reverseLL(LinkedList<Integer> ll) {
    Node<Integer> prev, curr, next;
    prev = null;
    curr = ll.head;
    next = ll.head;
    while(curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    ll.head = prev;
  }
}