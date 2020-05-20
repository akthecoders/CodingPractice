import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Queens That Can Attack the King
public class P1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean board[][] = new boolean[8][8];
        for (int q[] : queens) {
            int x = q[0];
            int y = q[1];
            board[x][y] = true;
        }

        List<List<Integer>> result = new ArrayList<>();
        int[] directions = { -1, 0, 1 };

        for (int dx : directions) {
            for (int dy : directions) {
                if (dx == 0 && dy == 0)
                    continue;
                int x = king[0];
                int y = king[1];

                while (x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
                    x += dx;
                    y += dy;
                    if (board[x][y]) {
                        result.add(Arrays.asList(x, y));
                        break;
                    }
                }
            }
        }
        return result;
    }
}