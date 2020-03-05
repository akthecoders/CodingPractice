/**
 * LinkedListTest
 */
public class LinkedListTest {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    ll.push(0);
    ll.append(3);
    ll.insertBefore(2, 3);
    ll.printList();

    ll.deleteGivenKey(2);
    ll.printList();
    
  }
}