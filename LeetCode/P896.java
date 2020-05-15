//Monotonic Array
public class P896 {
    public boolean isMonotonic(int[] A) {
        if (A.length == 1)
            return true;
        if (A.length == 0)
            return false;
        return isIncreasing(A) || isDecreasing(A);
    }

    public boolean isIncreasing(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isDecreasing(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                return false;
            }
        }
        return true;
    }
}