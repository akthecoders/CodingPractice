// Number of Steps to Reduce a Number to Zero

public class P1342 {
    public int numberOfSteps(int num) {
        if (num == 0)
            return 0;

        return 1 + numberOfSteps(num % 2 == 0 ? (int) num / 2 : (int) (num - 1));
    }
}