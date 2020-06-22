//Consecutive Characters
public class P1446 {
    public int maxPower(String s) {
        int max = 1, temp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i))
                temp++;
            else {
                if (temp > max)
                    max = temp;
                temp = 1;
            }
        }
        return max > temp ? max : temp;
    }
}