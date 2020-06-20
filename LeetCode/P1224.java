//Maximum Equal Frequency
public class P1224 {
    public int maxEqualFreq(int[] nums) {
        int count[] = new int[100001];
        int freq[] = new int[100001];

        for (int x : nums) {
            count[x]++;
            freq[count[x]]++;
        }

        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            if (freq[count[nums[i]]] * count[nums[i]] == i)
                return i + 1;

            freq[count[nums[i]]]--;
            count[nums[i]]--;

            if (freq[count[nums[i - 1]]] * count[nums[i - 1]] == i)
                return i + 1;
        }
        return 1;
    }
}