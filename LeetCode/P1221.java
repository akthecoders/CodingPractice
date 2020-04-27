// Split a String in Balanced Strings
public class P1221 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                count++;
            else
                count--;
            if (count == 0)
                index++;
        }
        return index;
    }
}