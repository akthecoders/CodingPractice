//String to Integer (atoi)
public class P8 {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty())
            return 0;
        int ptr = 0, sign = 1, num = 0;
        while (ptr < str.length() && str.charAt(ptr) == ' ')
            ptr++;
        if (ptr >= str.length())
            return 0;
        if (str.charAt(ptr) == '+' || str.charAt(ptr) == '-') {
            sign = (str.charAt(ptr) == '+') ? 1 : -1;
            ptr++;
        }

        while (ptr < str.length()) {
            Character c = str.charAt(ptr);
            ptr++;
            if (!Character.isDigit(c) && num == 0)
                return num;
            else if (!Character.isDigit(c) && num != 0)
                break;
            else if (!Character.isDigit(c))
                continue;

            int digit = c - '0';

            if (Integer.MAX_VALUE / 10 < num || Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            num = num * 10 + digit;
        }

        return sign * num;
    }
}