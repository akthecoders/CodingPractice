//Generate a String With Characters That Have Odd Counts
public class P1374 {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 1)
            return "a";
        if (n % 2 != 0) {
            for (int i = 0; i < n - 2; i++) {
                sb.append("a");
            }
            sb.append("b");
            sb.append("c");
        } else {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
        }
        return sb.toString();
    }
}