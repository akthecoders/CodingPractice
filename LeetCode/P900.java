//RLE Iterator
public class P900 {
    int[] A;
    int i, q;

    public P900(int[] A) {
        this.A = A;
        i = q = 0;
    }

    public int next(int n) {
        while (i < A.length) {
            if (q + n > A[i]) {
                n -= A[i] - q;
                q = 0;
                i += 2;
            } else {
                q += n;
                return A[i + 1];
            }
        }
        return -1;
    }
}