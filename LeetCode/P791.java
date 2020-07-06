//Custom Sort String
public class P791 {
    public String customSortString(String s, String t) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder(t);
        for (char ch : s.toCharArray()) {
            int index = sb1.indexOf(ch + "");
            while (index != -1) {
                sb.append(ch);
                sb1.deleteCharAt(index);
                index = sb1.indexOf(ch + "");
            }
        }
        sb.append(sb1);
        return sb.toString();
    }
}