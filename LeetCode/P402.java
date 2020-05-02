// Remove K Digits
public class P402 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length())
            return "0";
        StringBuilder res = new StringBuilder();

        for (char c : num.toCharArray()) {
            if (k > 0 && res.length() > 0 && res.charAt(res.length() - 1) > c) {
                while (k > 0 && res.length() > 0 && res.charAt(res.length() - 1) > c) {
                    res.deleteCharAt(res.length() - 1);
                    k--;
                }
            }
            res.append(c);
        }
        int nonZero = 0;
        while (nonZero < res.length() && res.charAt(nonZero) == '0')
            nonZero++;

        return res.length() - k <= nonZero ? "0" : res.substring(nonZero, res.length() - k);
    }
}