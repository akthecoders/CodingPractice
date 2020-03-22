/**
 * PatternOccurence
 */
import java.util.Stack;

public class PatternOccurence {

  public static void main(String[] args) {
    char[] pattern = "ABC".toCharArray(); 
    char[] text = "ABABCABCC".toCharArray();
    int [] pI = new int[text.length];
    getPatternMatch(pattern, text, pI);
    for (int i : pI) {
      System.out.println(i + " ");
    }  
  }

  public static void getPatternMatch(char[] pattern, char[] text, int[] pi) {
    Stack<Character> st = new Stack<>();
    int pointer = 0;
    int index = 0;
    for(int i = 0; i < text.length; i++) {
      if(pointer == pattern.length) {
        pi[index++] = i - 1;
        for(int j = 0; j < pattern.length; j++) {
          st.pop();
        }
        pointer = 0;
      }
      if(text[i] == pattern[pointer++]) {
        st.push(text[i]);
      }
      else {
        pointer = 0;
        if(text[i] == pattern[pointer++]) {
          st.push(text[i]);
        }
        else {
          st.push(text[i]);
        }
      }
    }
    int i = 0;
    if(!st.empty()) {
      for(i = pattern.length - 1; i >= 0; i--) {
        if(st.peek() == pattern[i]) {
          st.pop();
        }
        else {
          break;
        }
      }
    }
    if(i < 0) {
      pi[index] = text.length - 1;
    }
  }
}