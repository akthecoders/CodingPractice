/**
 * Celibrity
 */
import java.util.Stack;

public class Celibrity {

  static int MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

  static boolean knows(int a, int b) {
    boolean res = (MATRIX[a][b] == 1) ? true : false;
    return res;
  }

  public static int findCelebrity(int n) {
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < n; i++) {
      stack.push(i);
    }
    while(stack.size() > 1) {
      int a = stack.pop();
      int b= stack.pop();
      if(knows(a,b)) {
        stack.push(b);
      }
      else {
        stack.push(a);
      }
    }
    int c = stack.pop();
    for(int i = 0; i < n; i++)
      if (i != c && (knows(c, i) || !knows(i, c))) return -1; 

    return c;
  }

  public static void main(String[] args) {
    int n = 4;
    int result = findCelebrity(n);
    if (result == -1) {
      System.out.println("No Celebrity");
    } else
      System.out.println("Celebrity ID " + result);
  }
}