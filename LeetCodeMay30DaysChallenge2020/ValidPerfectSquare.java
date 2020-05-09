// Valid Perfect Square

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0)
            return true;
        int div = num / 2;
        for (int i = 1; i <= div; i++) {
            if (i * i == num)
                return true;
        }
        return false;
    }
}