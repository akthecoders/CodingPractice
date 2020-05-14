//Count and Say
public class P38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }

        String result = "11";

        for (int i = 2; i < n; i++) {
            String inner = "";
            int count = 0;
            for (int j = 0; j < result.length() - 1; j++) {
                if (result.charAt(j) != result.charAt(j + 1)) {
                    count++;
                    inner += (count) + String.valueOf(result.charAt(j));
                    count = 0;
                } else {
                    count++;
                }
            }

            if (result.charAt(result.length() - 2) != result.charAt(result.length() - 1)) {
                count = 0;
            }
            inner += (count + 1) + String.valueOf(result.charAt(result.length() - 1));
            result = inner;
        }

        return result;
    }
}