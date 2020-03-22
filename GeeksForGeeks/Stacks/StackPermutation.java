
/**
 * StackPermutation
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackPermutation {

  public static void main(String[] args) {
    int input[] = { 1, 2, 3 };

    // Output Queue
    int output[] = { 2, 1, 3 };
    int n = 3;
    if (checkStackPermutation(input, output, n))
      System.out.println("Yes");
    else
      System.out.println("Not Possible");
  }

  static boolean checkStackPermutation(int ip[], int op[], int n) {
      Queue<Integer> input = new LinkedList<>(); 
      for (int i = 0; i < n; i++) { 
        input.add(ip[i]); 
      }
      Queue<Integer> output = new LinkedList<>(); 
      for (int i = 0; i < n; i++) { 
        output.add(op[i]); 
      } 
      Stack<Integer> tempStack = new Stack<>();
      while(!input.isEmpty()) {
        int ele = input.poll();
        if(ele == output.peek()) {
          output.poll();
          while(!tempStack.empty() && output.peek() == tempStack.peek() ) {
            input.poll();
            tempStack.pop();
          }
        }
        else {
          tempStack.push(ele);
        }
      }
      return (input.isEmpty() && tempStack.isEmpty());
  }
}