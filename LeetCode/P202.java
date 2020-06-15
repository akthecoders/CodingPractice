import java.util.HashMap;
import java.util.Map;

//Happy Number
public class P202 {
    Map<Integer, Integer> dp = new HashMap<>();

    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        if (n == 0)
            return false;

        if (dp.containsKey(n)) {
            if (dp.get(n) == 1)
                return true;
            return false;
        }

        int digitSum = digitSquareSum(n);
        if (digitSum == 1)
            return true;

        dp.put(n, digitSum);
        return isHappy(digitSum);

    }

    public int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}