/**
 * LinkedList
 */
public class LinkedList<T> {
  Node<T> head;
  Node<T> end;
  int noOfNodes;

  public void printList() {
    Node<T> n = head;
    while(n != null) {
      System.out.println("Node : " + n.data);
      n = n.next;
    }
  }

  public void push(T data) {
    Node<T> newNode = new Node<>(data);
    if(head == null) {
      head = newNode;
      end = newNode;
      return;
    }
      newNode.next = head;
      head = newNode;
  }

  public void append(T data) {
    Node<T> newNode = new Node<T>(data);
    if(head == null) {
      head = newNode;
      end = newNode;
      return;
    }
    end.next = newNode;
    end  = newNode;
  }
  
  public void insertAfter(T data, T insertAfter) {
    Node<T> newNode = new Node<T>(data);
    if(head == null) {
      head = newNode;
      end = newNode;
      return;
    }

    Node<T> temp = head;
    while(temp != null) {      
      if(temp.data == insertAfter) {
        Node<T> tNode = temp.next;
        temp.next = newNode;
        newNode.next = tNode;
      }
      temp = temp.next;
    }
    if(temp == null) {
      System.out.println("No element found");
      return;
    }
  }

  public void insertBefore(T data, T insertBefore) {
    Node<T> newNode = new Node<T>(data);
    if(head == null) {
      head = newNode;
      end = newNode;
      return;
    }

    Node<T> temp = head;
    Node<T> prevNode = temp;
    if(temp.data == insertBefore) {
      Node<T> tNode = head.next;
      head.next = newNode;
      newNode.next = tNode;
    }
    temp = temp.next;

    while(temp != null) {      
      if(temp.data == insertBefore) {
        Node<T> tNode = prevNode.next;
        prevNode.next = newNode;
        newNode.next = tNode;
      }
      temp = temp.next;
    }
    if(temp == null) {
      System.out.println("No element found");
      return;
    }
  }

  public void deleteGivenKey(T data) {
    Node<T> temp = head;
    Node<T> prevNode = head;
    if(temp.data == data) {
      head = head.next;
      return;
    }
    temp = temp.next;
    while(temp != null) {
        if(temp.data == data) {
            break;
        }
        prevNode = temp;
        temp = temp.next;
    }

    if(temp == null) {
      System.out.println("No such node to delete");
      return;
    }
    prevNode.next = temp.next;
  }
}