// Maximum 69 Number
public class P1323 {
    public int maximum69Number(int num) {
        int max = num;
        int count = 0;
        int lastIndex = Integer.MAX_VALUE;

        while (max > 0) {
            int temp = max % 10;
            if (temp == 6)
                lastIndex = count;
            max = max / 10;
            count++;
        }

        if (lastIndex == Integer.MAX_VALUE)
            return num;

        double temp = Math.pow(10, lastIndex);
        return num - (int) temp * 6 + (int) temp * 9;
    }
}