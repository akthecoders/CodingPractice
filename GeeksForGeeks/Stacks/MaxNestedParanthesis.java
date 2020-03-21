/**
 * MaxNestedParanthesis
 */
public class MaxNestedParanthesis {

  public static void main(String[] args) {
    String s = "( ((X)) (((Y))) )"; 
    System.out.println(maxDepth(s)); 
  }

  public static int maxDepth(String s) {
    int maxDepth = 0;
    int popCount = 0;
    Stack stack = new Stack();
    
    for(int i = 0 ; i < s.length(); i++) {
      if(s.charAt(i) == '(') {
        popCount = 0;
        stack.push(i);
      }
      else if(s.charAt(i) == ')') {
        stack.pop();
        popCount++;
        if(maxDepth < popCount) {
          maxDepth = popCount;
        }
      }
    }
    return maxDepth;
  }
}