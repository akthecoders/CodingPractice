/**
 * Loop
 */
public class Loop {

  public static void main(String[] args) {
    LinkedList<Integer> root = new LinkedList<>();
    root.append(0);
    root.append(1);
    root.append(2);
    root.append(3);
    root.append(4);
    
    root.head.next.next.next = root.head;
  }

  public static void isLoop(LinkedList<Integer> root) {
    Node<Integer> head = root.head;
    Node<Integer> fast_head = root.head;

    while(head != null && fast_head != null && fast_head.next != null) {
      head = head.next;
      fast_head = fast_head.next.next;
      if(head == fast_head) {
        System.out.println("Loop detected");
        return;
      }
    }
  }
}