import java.util.HashSet;
import java.util.Set;

// Sudoku Solver
public class P37 {
    public void solveSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                addToSet(set, i, j, board[i][j]);
            }
        }
        backtrack(board, set);
    }

    private boolean backtrack(char[][] board, Set<String> set) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (!isValid(set, i, j, k))
                        continue;
                    board[i][j] = k;
                    addToSet(set, i, j, k);
                    if (backtrack(board, set))
                        return true;
                    removeFromSet(set, i, j, k);
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(Set<String> set, int i, int j, char k) {
        if (set.contains("" + k + "row-" + i))
            return false;
        if (set.contains("" + k + "col-" + j))
            return false;
        if (set.contains("" + k + "block-" + (i / 3) + (j / 3)))
            return false;
        return true;

    }

    private void addToSet(Set<String> set, int i, int j, char k) {
        set.add("" + k + "row-" + i);
        set.add("" + k + "col-" + j);
        set.add("" + k + "block-" + (i / 3) + (j / 3));
    }

    private void removeFromSet(Set<String> set, int i, int j, char k) {
        set.remove("" + k + "row-" + i);
        set.remove("" + k + "col-" + j);
        set.remove("" + k + "block-" + (i / 3) + (j / 3));
    }
}