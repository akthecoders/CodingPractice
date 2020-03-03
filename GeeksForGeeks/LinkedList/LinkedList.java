/**
 * LinkedList
 */
public class LinkedList<T> {
  Node<T> head;

  public void printList() {
    Node<T> n = head;
    while(n != null) {
      System.out.println("Node : " + n.data);
      n = n.next;
    }
  }
}