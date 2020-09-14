import java.util.LinkedList;
import java.util.Queue;

// Minimum Knight Moves
public class P1197 {
    int[][] dir = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }

        if (x < 10 && y < 10) {
            // use naive bfs here
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] { 0, 0 });
            int step = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int[] pos = q.poll();
                    if (x == pos[0] && y == pos[1])
                        return step;
                    for (int i = 0; i < 4; i++) {
                        int X1 = pos[0] + dir[i][0], X2 = pos[0] + dir[i][1];
                        int Y1 = pos[1] + dir[i][1], Y2 = pos[1] + dir[i][0];
                        q.add(new int[] { X1, Y1 });
                        q.add(new int[] { X2, Y2 });
                    }
                }
                step++;
            }
        }
        // x <= 2 * y;
        // m ( 2, 1) + n (1, 2) = (2m + n, 2n + m) = (x, y)
        if (x <= 2 * y) {
            if ((x + y) % 3 == 0)
                return (x + y) / 3;
            if ((x + y) % 3 == 1)
                return 1 + (x + y - 1) / 3;
            return Math.min(1 + (x + y + 1) / 3, 2 + (x + y - 2) / 3);
        }
        // x > 2 * y, x >= 0
        // m (2, 1) + n (2, -1) = (2 (m + n), m - n) = (x, y)
        if (x % 2 == 0) {
            if ((x / 2 + y) % 2 == 0)
                return x / 2;
            return 1 + x / 2;
        }

        if (((x - 1) / 2 + y) % 2 == 0)
            return 1 + (x - 1) / 2;
        return 3 + (x - 3) / 2;
    }
}
