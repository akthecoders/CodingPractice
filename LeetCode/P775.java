//Global and Local Inversions
public class P775 {
    public boolean isIdealPermutation(int[] A) {
        int min = A[A.length - 1];
        for (int i = A.length - 3; i >= 0; i--) {
            if (min < A[i]) {
                return false;
            }
            min = Math.min(min, A[i + 1]);
        }
        return true;
    }
}