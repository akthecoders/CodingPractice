import java.util.ArrayList;
import java.util.List;

//Add to Array-Form of Integer
public class P989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        if (A.length == 0)
            return result;
        int carry = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int a = A[i];
            int b = K % 10;
            K = K / 10;
            int c = carry;
            int sum = a + b + c;
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            result.add(0, sum);
        }
        if (K != 0) {
            while (K != 0) {
                int sum = K % 10 + carry;
                carry = sum > 9 ? 1 : 0;
                sum = sum % 10;
                result.add(0, sum);
                K = K / 10;
            }
        }
        if (carry != 0)
            result.add(0, carry);
        return result;
    }
}