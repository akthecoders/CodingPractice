//Sort Array By Parity
public class P905 {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length <= 1)
            return A;

        int l = 0;
        int r = A.length - 1;

        while (l < r) {
            if (odd(A[l])) {
                while (l < r) {
                    if (odd(A[r])) {
                        r--;
                    } else {
                        int tmp = A[r];
                        A[r] = A[l];
                        A[l] = tmp;
                        break;
                    }
                }
            }

            l++;
        }

        return A;
    }

    public boolean odd(int n) {
        return n % 2 != 0;
    }
}