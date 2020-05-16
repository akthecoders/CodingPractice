//Pairs of Songs With Total Durations Divisible by 60
public class P1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] bucket = new int[60];
        int count = 0;
        for (int x : time) {
            int mod = x % 60;
            int diff = mod == 0 ? 0 : 60 - mod;
            count += bucket[diff];
            bucket[mod]++;
        }
        return count;
    }
}