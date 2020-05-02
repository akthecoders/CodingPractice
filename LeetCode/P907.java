//Sum of Subarray Minimums
import java.util.*;
public class P907 {
    class Pair {
        int val;
        int count;

        Pair(int v, int c) {
            this.val = v;
            this.count = c;
        }
    }

    public int sumSubarrayMins(int[] A) {
        Stack<Pair> stack = new Stack<>();
        int n = A.length;
        int left[] = new int[n];
        int right[] = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek().val > A[i]) {
                count += stack.pop().count;
            }
            left[i] = count;
            stack.push(new Pair(A[i], count));
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek().val >= A[i]) {
                count += stack.pop().count;
            }
            right[i] = count;
            stack.push(new Pair(A[i], count));
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + A[i] * left[i] * right[i]) % 1000000007;
        }
        return result;
    }
}