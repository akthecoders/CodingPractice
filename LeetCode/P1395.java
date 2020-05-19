//Count Number of Teams
import java.util.Arrays;

public class P1395 {
    public int numTeams(int[] rating) {
        int inc[] = new int[2];
        int dec[] = new int[2];
        int res = 0;
        for (int i = 0; i < rating.length; i++) {
            Arrays.fill(inc, 0);
            Arrays.fill(dec, 0);
            int j = i - 1;
            int k = i + 1;
            while (j >= 0) {
                if (j >= 0 && (rating[j] < rating[i]))
                    inc[0]++;
                if (j >= 0 && (rating[j] > rating[i]))
                    dec[0]++;
                j--;
            }
            while (k < rating.length) {
                if (k < rating.length && (rating[k] > rating[i]))
                    inc[1]++;
                if (k < rating.length && (rating[k] < rating[i]))
                    dec[1]++;
                k++;
            }
            res += (inc[0] * inc[1] + dec[0] * dec[1]);
        }
        return res;
    }
}