//Sort Array By Parity II
public class P922 {
    public int[] sortArrayByParityII(int[] A) {
        int j;
        for (int i = 0; i < A.length; i++) {
            j = i;
            if (i % 2 == 0 && A[i] % 2 != 0) {
                j = i + 1;
                while (A[j] % 2 != 0) {
                    j++;
                }
            } else if (i % 2 == 1 && A[i] % 2 != 1) {
                j = i + 1;
                while (A[j] % 2 != 1) {
                    j++;
                }
            }
            if (j != i) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}