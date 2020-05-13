//Maximum Score After Splitting a String
public class P1422 {
    public int maxScore(String s) {
        int[] left = new int[s.length()], right = new int[s.length()];
        fillLeft(s, left);
        fillRight(s, right);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;

    }

    public void fillLeft(String s, int[] left) {
        int countZeroes = 0;
        for (int i = 0; i < s.length(); i++) {
            left[i] = s.charAt(i) == '0' ? ++countZeroes : countZeroes;
        }
    }

    public void fillRight(String s, int[] right) {
        int countOnes = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            right[i] = s.charAt(i) == '1' ? ++countOnes : countOnes;
        }
    }
}