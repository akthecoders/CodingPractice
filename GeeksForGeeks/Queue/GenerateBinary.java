/**
 * GenerateBinary
 */
import java.util.LinkedList; 
import java.util.Queue; 

public class GenerateBinary {

  public static void main(String[] args) {
    int n = 5;
    generatePrintBinary(n); 
  }

  public static void generatePrintBinary(int n) {
    Queue<String> q = new LinkedList<>();
    q.add("1");
    while(n-- > 0) {
      String q1 = q.peek();
      q.remove();
      System.out.println(q1);
      String q2 = q1;
      q.add(q1 + "0");
      q.add(q2 + "1");
    }
  }
}