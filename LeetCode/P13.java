//Roman to Integer
public class P13 {
    public int romanToInt(String s) {
        int previous = 0, current = 0, ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I')
                current = 1;
            else if (s.charAt(i) == 'V')
                current = 5;
            else if (s.charAt(i) == 'X')
                current = 10;
            else if (s.charAt(i) == 'L')
                current = 50;
            else if (s.charAt(i) == 'C')
                current = 100;
            else if (s.charAt(i) == 'D')
                current = 500;
            else if (s.charAt(i) == 'M')
                current = 1000;
            if (previous > current)
                ans -= current;
            else
                ans += current;
            previous = current;
        }
        return ans;
    }
}