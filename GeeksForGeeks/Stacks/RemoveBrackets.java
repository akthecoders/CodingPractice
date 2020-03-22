/**
 * RemoveBrackets
 */
import java.util.Stack;

public class RemoveBrackets {

  public static void main(String[] args) {
    String s1 = "a-(b+c)";  
    String s2 = "a-(b-c-(d+e))-f";  
    System.out.println(simplify(s1));  
    System.out.println(simplify(s2)); 
  }

  public static String simplify(String str) {
    int len = str.length();  
    char res[] = new char[len];  
    int index = 0, i = 0;  
    Stack<Integer> s = new Stack<Integer> ();  
    s.push(0);  
    
    while(i < len) {
      if(str.charAt(i) == '+') {
        if(s.peek() == 1) {
          res[index++] = '-';
        }
        else {
          res[index++] = '+';
        }
      }
      else if(str.charAt(i) == '-') {
        if(s.peek() == 1) {
          res[index++] = '+';
        }
        else {
          res[index++] = '-';
        }
      }
      else if(str.charAt(i) == '(' && i > 0) {
        if(str.charAt(i - 1) == '-') {
         int x = s.peek() == 1 ? 0 : 1;
         s.push(x);
        }
      }
      else if(str.charAt(i) == ')') {
        s.pop();
      }
      else {
        res[index++] = str.charAt(i);
      }
      i++;
    }

    return new String(res);
  }
}