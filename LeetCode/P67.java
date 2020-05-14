//Add Binary
public class P67 {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        Character sum = '0';
        Character carry = '0';

        while (i >= 0 || j >= 0) {
            Character one = i < 0 ? '0' : a.charAt(i);
            Character two = j < 0 ? '0' : b.charAt(j);

            if (one == '1' && one == two) {
                if (carry == '1') {
                    sum = '1';
                    carry = '1';
                } else {
                    sum = '0';
                    carry = '1';
                }
            } else if (one == '0' && two == '0') {
                if (carry == '1') {
                    sum = '1';
                    carry = '0';
                } else {
                    sum = '0';
                    carry = '0';
                }
            } else {
                if (carry == '1') {
                    carry = '1';
                    sum = '0';
                } else {
                    sum = '1';
                    carry = '0';
                }
            }
            str.append(sum);
            i--;
            j--;
        }
        if (carry == '1')
            str.append(carry);
        return str.reverse().toString();
    }
}