/**
 * ReverseAlternateNode
 */
public class ReverseAlternateNode {

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
    root.head = reverseAlternate(root.head, 3, true);
    root.printList();
  }

  public static Node<Integer> reverseAlternate(Node<Integer> node, int k, boolean b) { 
    if(node == null) {
      return null;
    }

    int count = 1;
    Node<Integer> prev = null;
    Node<Integer> curr = node;
    Node<Integer> next = null;

    while(curr != null && count <= k) {
      next = curr.next;
      if(b) {
        curr.next = prev;
      }
      prev = curr;
      curr = next;
      count++;
    }

    if(b) {
      node.next = reverseAlternate(curr, k, !b);
      return prev;
    }
    prev.next = reverseAlternate(curr, k, !b);
    return node;
  }
}