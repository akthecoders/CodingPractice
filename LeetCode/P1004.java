//Max Consecutive Ones III
public class P1004 {
    public int longestOnes(int[] A, int K) {
        int lP = 0;
        int maxLength = 0;
        int currLength = 0;
        int flipped = 0;
        for (int rP = 0; rP < A.length; rP++) {
            if (A[rP] == 0) {
                flipped++;
            }

            if (flipped <= K) {
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            } else {
                maxLength = Math.max(maxLength, currLength);
                currLength++;
                while (flipped > K) {
                    if (A[lP] == 0) {
                        flipped--;
                    }
                    lP++;
                    currLength--;
                }
            }
        }
        return maxLength;
    }
}