/**
 * PairWiseSwap
 */
public class PairWiseSwap {

  public static void main(String[] args) {
    LinkedList<Integer> root = new LinkedList<>();
    root.append(0);
    root.append(1);
    root.append(2);
    root.append(3);
    root.append(4);
    root.append(5);
    root.append(6);
    root.append(7);
    root.append(8);
    root.append(9);
    root.printList();
    root.head = swapPairWise(root.head);
    root.printList();
  }

  public static Node<Integer> swapPairWise(Node<Integer> head) {
    if(head == null || head.next == null) {
      return head;
    }

    Node<Integer> prev = head;
    Node<Integer> curr = head.next;
    Node<Integer> next = null;
    
    head = curr;
    while(true) {
      next = curr.next;
      curr.next = prev;
      if(next == null || next.next == null) {
        prev.next = next;
        break;
      }

      prev.next = next.next;
      prev = next;
      curr = prev.next;
    }
    return head;
  }
}