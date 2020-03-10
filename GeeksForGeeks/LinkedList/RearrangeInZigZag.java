/**
 * RearrangeInZigZag
 */
public class RearrangeInZigZag {

  public static void main(String[] args) {
    LinkedList<Integer> root = new LinkedList<>();
    root.append(1);
    root.append(2);
    root.append(3);
    root.append(4);
    root.printList();
    zigZag(root.head);
    root.printList();
  }

  public static void zigZag(Node<Integer> head) {
    Node<Integer> curr = head;
    boolean flag = true;
    while(curr != null && curr.next != null) {
      if(flag) {
        if(curr.data > curr.next.data) {
          Integer temp = curr.data;
          curr.data =  curr.next.data;
          curr.next.data = temp;
        }
      }
      else {
        if(curr.data < curr.next.data) {
          Integer temp = curr.data;
          curr.data =  curr.next.data;
          curr.next.data = temp;
        }
      }
      curr = curr.next;
      flag = !flag;
    }
  }
}