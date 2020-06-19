import java.util.Arrays;

//H-Index
public class P274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        if (len == 0)
            return 0;
        int j = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] <= ++j) {
                if (j > citations[i]) {
                    return len - i - 1;
                } else
                    return j;
            }
        }
        return len;
    }
}