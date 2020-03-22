/**
 * CheckIfTwoExpressionsAreSame
 */
import java.util.Stack;

public class CheckIfTwoExpressionsAreSame {
  static final int MAX_CHAR = 26;
  public static void main(String[] args) {
    String expr1 = "-(a+b+c)", expr2 = "-a-b-c";
    if (areSame(expr1, expr2))
      System.out.println("Yes");
    else
      System.out.println("No");
  }

  public static boolean areSame(String exp1, String exp2) {
    int [] v = new int[MAX_CHAR];
    eval(exp1, v, true);
    eval(exp2, v, false);
    for (int i = 0; i < MAX_CHAR; i++) 
            if (v[i] != 0) 
                return false; 
  
        return true; 
  }

  public static void eval(String exp, int[] v, boolean add) {
    Stack<Boolean> stk = new Stack<>();
    stk.push(true);

    int i = 0; 
    while(i < exp.length()) {
      if(exp.charAt(i) == '+' || exp.charAt(i) == '-') {
        i++;
        continue;
      }
      if(exp.charAt(i) == '(') {
        if (adjSign(exp, i)) 
            stk.push(stk.peek()); 
        else
            stk.push(!stk.peek()); 
      }
      else if(exp.charAt(i) == ')') {
        stk.pop();
      }
      else  {
        if(stk.peek()) {
          v[exp.charAt(i) - 'a'] += (adjSign(exp, i) ?  add ? 1 : -1 : add ? -1 : 1); 
        }
        else {
          v[exp.charAt(i) - 'a'] += (adjSign(exp, i) ?  add ? -1 : 1 : add ? 1 : -1); 
        }
      }
      i++;
    }
  }

  static boolean adjSign(String s, int i)  
    { 
        if (i == 0) 
            return true; 
        if (s.charAt(i - 1) == '-') 
            return false; 
        return true; 
    }; 
}