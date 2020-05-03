// Task Scheduler
public class P621 {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks)
            counts[c - 'A']++;
        int max = 0;
        int maxCount = 0;
        for (int count : counts) {
            if (count > max) {
                max = count;
                maxCount = 1;
            } else if (count == max) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, max + n * (max - 1) + maxCount - 1);
    }
}