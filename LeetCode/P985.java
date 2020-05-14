//Sum of Even Numbers After Queries
public class P985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenSum = 0;
        for (int x : A) {
            if (x % 2 == 0)
                evenSum += x;
        }

        int result[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int value = queries[i][0];

            if (A[index] % 2 == 0) {
                if (value % 2 == 0) {
                    evenSum += value;
                } else {
                    evenSum -= A[index];
                }
            } else {
                if (value % 2 != 0) {
                    evenSum = evenSum + A[index] + value;
                }
            }
            A[index] += value;
            result[i] = evenSum;
        }
        return result;
    }
}