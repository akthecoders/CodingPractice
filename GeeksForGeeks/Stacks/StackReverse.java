/**
 * StackReverse
 */
public class StackReverse {

  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);

    reverseStack(stack);

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  public static void reverseStack(Stack stack) {
    if(stack.isEmpty()) {
      return;
    }
    int val = stack.pop();
    reverseStack(stack);
    insertAtBottom(stack, val);
    return;
  }

  public static void insertAtBottom(Stack stack, int value) {
    if(stack.isEmpty()) {
      stack.push(value);
      return;
    }
    int tVal = stack.pop();
    insertAtBottom(stack, value);
    stack.push(tVal);
  }
}