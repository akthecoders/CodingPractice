import java.util.Arrays;

//Task Scheduler
public class P621 {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int i : tasks)
            freq[i - 'A']++;

        Arrays.sort(freq);

        int maxF = freq[25];
        int maxIdle = (maxF - 1) * n;

        for (int i = 24; i >= 0 && maxIdle > 0; --i) {
            maxIdle -= Math.min(maxF - 1, freq[i]);
        }

        maxIdle = Math.max(0, maxIdle);

        return tasks.length + maxIdle;
    }
}