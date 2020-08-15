//Count and Say
public class P38 {
    public String countAndSay(int n) {
        if (n == 0)
            return "";
        String finalString = "1";
        if (n == 1)
            return finalString;

        int left = 0;
        int right = 0;
        String currString = "";

        while (n > 1) {
            while (right < finalString.length()) {
                while (right < finalString.length() && finalString.charAt(left) == finalString.charAt(right)) {
                    right++;
                }

                currString += "" + (right - left);
                currString += finalString.charAt(left);
                left = right;
            }
            finalString = currString;
            currString = "";
            left = 0;
            right = 0;
            n--;
        }
        return finalString;
    }
}