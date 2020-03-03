/**
 * LinkedListTest
 */
public class LinkedListTest {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    ll.head = new Node<Integer>(1);
    Node<Integer> first = new Node<>(2);
    Node<Integer> second = new Node<>(3);
    ll.head.next = first;
    first.next = second;
    ll.printList();
  }
}