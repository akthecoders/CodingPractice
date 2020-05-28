//Corporate Flight Bookings
public class P1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int count[] = new int[n];
        for (int[] booking : bookings) {
            int x = booking[0];
            int y = booking[1];
            if (y < count.length) {
                count[y] = count[y] - booking[2];
            }
            count[x - 1] = count[x - 1] + booking[2];

        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }
        return count;
    }
}