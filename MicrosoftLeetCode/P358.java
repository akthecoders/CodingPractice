import java.util.Arrays;

//Rearrange String k Distance Apart
public class P358 {
    static int MAX_CHAR = 256;

    public String rearrangeString(String s, int k) {
        char str[] = s.toCharArray();
        int n = str.length;

        char[] out = new char[n];

        if (rearrange(str, out, k) == 1)
            return String.valueOf(out);
        return "";
    }

    public int rearrange(char str[], char out[], int d) {
        int n = str.length;

        int[] freq = new int[MAX_CHAR];

        for (int i = 0; i < n; i++)
            freq[str[i]]++;

        int[] dist = new int[MAX_CHAR];

        for (int i = 0; i < n; i++) {
            int j = nextChar(freq, dist);

            if (j == Integer.MIN_VALUE)
                return 0;

            out[i] = (char) j;

            freq[j]--;

            dist[j] = d;

            for (int k = 0; k < MAX_CHAR; k++)
                dist[k]--;
        }
        Arrays.copyOfRange(out, 0, n);
        return 1;
    }

    public int nextChar(int freq[], int dist[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < MAX_CHAR; i++)
            if (dist[i] <= 0 && freq[i] > 0 && (max == Integer.MIN_VALUE || freq[i] > freq[max]))
                max = i;

        return max;
    }
}