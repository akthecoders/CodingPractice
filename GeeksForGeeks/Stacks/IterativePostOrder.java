
/**
 * IterativePostOrder
 */
import java.util.Stack;

public class IterativePostOrder {

  static class node {
    int data;
    node left, right;

    public node(int data) {
      this.data = data;
    }
  }

  // Two stacks as used in explanation
  static Stack<node> s1, s2;

  public static void main(String[] args) {
    node root = null;
    root = new node(1);
    root.left = new node(2);
    root.right = new node(3);
    root.left.left = new node(4);
    root.left.right = new node(5);
    root.right.left = new node(6);
    root.right.right = new node(7);

    postOrderIterative(root);
  }

  public static void postOrderIterative(node root) {
    s1 = new Stack<>();
    s2 = new Stack<>();

    if (root == null)
      return;

    // push root to first stack
    s1.push(root);

    while (!s1.isEmpty()) {
      node item = s1.pop();
      s2.push(item);
      if (item.left != null)
        s1.push(item.left);

      if (item.right != null)
        s1.push(item.right);
    }

    while (!s2.isEmpty()) {
      node temp = s2.pop();
      System.out.print(temp.data + " ");
    }
  }
}