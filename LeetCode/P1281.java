// Subtract the Product and Sum of Digits of an Integer
public class P1281 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        int p = n;
        while (p > 0) {
            int temp = p % 10;
            product *= temp;
            sum += temp;
            p = p / 10;
        }

        return product - sum;
    }
}