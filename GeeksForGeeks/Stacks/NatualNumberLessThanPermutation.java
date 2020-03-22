/**
 * NatualNumberLessThanPermutation
 */
import java.util.Stack;

public class NatualNumberLessThanPermutation {

  public static void main(String[] args) {
    int n = 15;
    System.out.println(countNumber(n));
  }

  public static int countNumber(int n) {
    int result = 0;
    for(int i = 1; i <= 9; i++) {
      Stack<Integer> s = new Stack<>();
      if(i <= n) {
        s.push(i);
        result++;
      }

      while(!s.empty()) {
        int tp = s.peek();
        s.pop();
        for( int j = tp %10 ; j <= 9; j++) {
          int x = tp * 10 + j;
          if(x <= n) {
            s.push(x);
            result++;
          }
        }
      }
    }

    return result;
  }
}