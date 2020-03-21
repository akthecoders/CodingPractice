
/**
 * SortStackUsingRecursion
 */
import java.util.ListIterator;
import java.util.Stack;

public class SortStackUsingRecursion {

  static void printStack(Stack<Integer> s) {
    ListIterator<Integer> lt = s.listIterator();

    // forwarding
    while (lt.hasNext())
      lt.next();

    // printing from top to bottom
    while (lt.hasPrevious())
      System.out.print(lt.previous() + " ");
  }

  // Driver method
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(30);
    s.push(-5);
    s.push(18);
    s.push(14);
    s.push(-3);
    System.out.println("Stack elements before sorting: ");
    printStack(s);
    sortStack(s);
    System.out.println(" \n\nStack elements after sorting:");
    printStack(s);
  }

  public static void sortStack(Stack<Integer> s) {
    if(!s.isEmpty()) {
      int poppd = s.pop();
      sortStack(s);
      sortInserted(s, poppd);
    }
  }

  public static void sortInserted(Stack<Integer> s, int poppd) {
    if(s.isEmpty() || s.peek() < poppd) {
      s.push(poppd);
    }
    else {
      int temp = s.pop();
      sortInserted(s, poppd);
      s.push(temp);
    }
  }
}