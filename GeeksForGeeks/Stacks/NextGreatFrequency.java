/**
 * NextGreatFrequency
 */
public class NextGreatFrequency {

  public static void main(String[] args) {
    int a[] = {1, 1, 2, 3, 4, 2, 1};
    int len = 7;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) 
    { 
        //Getting the max element of the array 
        if (a[i] > max)
        { 
            max = a[i]; 
        } 
    } 
    int freq[] = new int[max + 1]; 
      
    for (int i = 0; i < max + 1; i++) 
    freq[i] = 0; 
      
    //Calculating frequency of each element 
    for (int i = 0; i < len; i++)  
    { 
        freq[a[i]]++; 
    } 
  
    NFG(a, len, freq); 
  }

  public static void NFG(int [] a, int n, int[] freq) {
    Stack stack = new Stack();
    int res[] = new int[n];
    for(int i = 0; i < n; i++) {
      if(freq[a[stack.peek()]] > freq[a[i]]) {
        stack.push(i);
      }
      else {
        while(!stack.isEmpty() && freq[a[stack.peek()]] < freq[a[i]]) {
          res[stack.peek()] = a[i];
          stack.pop();
        }
      }
      stack.push(i);
    }

    while(!stack.isEmpty()) {
      res[stack.peek()] = -1;
      stack.pop();
    }

    for (int i = 0; i < n; i++) 
    { 
      System.out.print( res[i] + " "); 
    } 
  }
}  