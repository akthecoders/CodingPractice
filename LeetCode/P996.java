// Number of Squareful Arrays

import java.util.*;
public class P996 {
    int count = 0;

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        helper(new ArrayList<Integer>(), A, new boolean[A.length], -1);
        return count;
    }

    void helper(ArrayList<Integer> temp, int[] A, boolean[] used, int lastNum) {
        if (temp.size() == A.length) {
            count++;
            return;
        } else {
            for (int i = 0; i < A.length; i++) {
                if (used[i] || (i > 0 && A[i] == A[i - 1] && !used[i - 1]))
                    continue;
                if (lastNum != -1) {
                    if (!isSquare(A[i], lastNum)) {
                        continue;
                    }
                }
                used[i] = true;
                temp.add(A[i]);
                helper(temp, A, used, A[i]);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    private boolean isSquare(int a, int b) {
        double sqr = Math.sqrt(a + b);
        boolean res = (sqr - Math.floor(sqr)) == 0;
        return res;
    }
}