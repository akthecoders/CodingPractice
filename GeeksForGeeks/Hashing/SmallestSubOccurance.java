import java.util.HashMap;

/**
 * SmallestSubOccurance
 */
public class SmallestSubOccurance {

    public static void main(String[] args) {
        int A[] = { 1, 2, 2, 2, 1 }; 
        int n = A.length; 
        smallestSubsegment(A, n); 
    }

    public static void smallestSubsegment(int[] A, int n) {
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int mx = 0;
        int mn = - 1, startIndex = -1;
        
        for(int i = 0; i < n; i++) {
            int x = A[i];
            if(left.get(x)== null) {
                left.put(x, i);
                count.put(x, 1);
            }
            else {
                count.put(x, count.get(x) + 1);
            }

            if(count.get(x) > mx) {
                mx = count.get(x);
                startIndex = left.get(x);
                mn = i - left.get(x) + 1;
            }
            else if(count.get(x) == mx) {
                if((i - left.get(x)  +  1) < mn) {
                    startIndex = left.get(x);
                    mn = i - left.get(x) + 1;
                }
            }
        }
        for (int i = startIndex; i < startIndex + mn; i++) 
            System.out.print(A[i] + " "); 
    }
}