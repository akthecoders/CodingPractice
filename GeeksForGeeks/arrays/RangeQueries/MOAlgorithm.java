package RangeQueries;

/**
 * MOAlgorithm
 */
public class MOAlgorithm {

    public static void main(String[] args) {
        int a[] = {1, 1, 2, 1, 3, 4, 5, 2, 8}; 
        int q[][] = {{0, 4}, {1, 3}, {2, 4}}; 
        moAlgorithm(a,q); 
    }

    public static void moAlgorithm(int[] arr, int[][] query) {
      int currL = 0;
      int currR = 0;
      int  L = 0;
      int R = 0;
      int sum = 0;
      for(int i = 0; i < query.length; i++) {
        L = query[i][0];
        R = query[i][1];

        while(currL < L) {
          sum -=  arr[currL];
          currL++;
        }

        while(currL > L) {
          sum += arr[currL - 1];
          currL--;
        }

        while(currR <= R) {
          sum += arr[currR];
          currR++;
        }

        while (currR > R+1) 
        { 
            sum -= arr[currR-1]; 
            currR--; 
        }

        System.out.println("Sum of [" + L + ", " + R + "] is" + sum);
      }
    }    
}