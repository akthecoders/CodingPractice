//Prison Cells After N Days
public class P957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = N % 14 == 0 ? 14 : N % 14;

        int prev[] = null;
        for (int i = 0; i < N; i++) {
            prev = new int[8];
            for (int j = 0; j < 8; j++) {
                if (j == 0 || j == 7) {
                    prev[j] = 0;
                } else {
                    prev[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
                }
            }
            cells = prev;
        }
        return cells;
    }
}