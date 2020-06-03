//Get Equal Substrings Within Budget
public class P1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0;
        int max = 0;
        int sum = 0;
        for (int j = 0; j < t.length(); j++) {
            sum += Math.abs((int) t.charAt(j) - (int) s.charAt(j));
            while (sum > maxCost) {
                sum -= Math.abs((int) t.charAt(i) - (int) s.charAt(i));
                i++;
            }
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}