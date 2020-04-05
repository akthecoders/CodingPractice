import java.util.HashMap;

/**
 * Permutation
 */
public class Permutation {

    public static void main(String[] args) {
        int A[] = { 2, 2, 3, 3 };
        int n = A.length;
        makePermutation(A, n);
        for (int i = 0; i < n; i++)
            System.out.print(A[i] + " ");
    }

    public static void makePermutation(int[] A, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            }
            else {
                map.put(A[i], 1);
            }
        }

        int nextMissing = 1;
        for(int i = 0; i < n; i++) {
            if(map.containsKey(A[i]) && map.get(A[i]) != 1 || A[i] > n || A[i] < 1) {
                map.put(A[i], map.get(A[i]) -1 );
                while(map.containsKey(nextMissing)) {
                    nextMissing++;
                }
                A[i] = nextMissing;
                map.put(nextMissing, 1);
            }
        }
    }
}