/**
 * NEGToRight
 */
public class NEGToRight {

  public static void main(String[] args) {
    int a[] = { 3, 4, 2, 7, 5, 8, 10, 6 }; 
    int n = a.length; 
  
    int dp[] = new int[n]; 
  
    count(a, dp, n); 
  
    System.out.println(answerQuery(dp, 3)); 
  
    System.out.println( answerQuery(dp, 6)); 
      
    System.out.println( answerQuery(dp, 1) ); 
  }

  static int answerQuery(int dp[], int index) { 
    return dp[index]; 
  }
  
  public static void count(int[] a, int dp[], int n) {
    int[] next = new int[n];
    for(int i = 0; i < n; i++) 
      next[i] = 0;  
    fillNext(next, a, n);

    for(int i = n - 2; i >= 0; i--) {
      if(next[i] == -1) {
        dp[i] = 0;
      }
      else {
        dp[i] = 1 + dp[next[i]];
      }
    }
  }

  public static void fillNext(int[] next, int a[] , int n) {
    Stack stack = new Stack();
    for(int i = 0; i < n; i++) {
      while(!stack.isEmpty() && a[stack.peek()] <a[i]) {
        next[stack.pop()] = i;
      }
      stack.push(i);
    }
    while(!stack.isEmpty()) {
      next[stack.pop()] = -1;
    }
  }
  
}