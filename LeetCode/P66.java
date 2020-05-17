import java.util.ArrayList;

//Plus One
public class P66 {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                int sum = carry + digits[i] + 1;
                carry = sum > 9 ? 1 : 0;
                sum = sum % 10;
                res.add(0, sum);
            } else {
                int sum = carry + digits[i];
                carry = sum > 9 ? 1 : 0;
                sum = sum % 10;
                res.add(0, sum);
            }
        }
        if (carry == 1) {
            res.add(0, 1);
        }
        int result[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}