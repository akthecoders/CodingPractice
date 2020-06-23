//Count Numbers with Unique Digits
public class P357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            result += (naiveFactorial(10) / naiveFactorial(10 - i)) * 0.9; // exclude numbers starting with 0
        }

        result++; // adding the count for 0 which is an exception on the above forumla

        return result;
    }

    private int naiveFactorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
}