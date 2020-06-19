import java.util.Arrays;
// Valid Sudoku
public class P36 {
    public boolean isValidSudoku(char[][] board) {
        // Frequency array.
        boolean[] freq = new boolean[10];
        // Check that the rows don't contain duplicates.
        for (int i = 0; i < board.length; i++) {
            // Reset the frequency array everytime we check a row.
            Arrays.fill(freq, false);
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;
                int index = (int) (board[i][j] - '1');
                if (freq[index])
                    return false;
                freq[index] = true;
            }
        }
        // Check that the columns don't contain duplicates.
        for (int i = 0; i < board.length; i++) {
            // Reset the frequency array everytime we check a column.
            Arrays.fill(freq, false);
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == '.')
                    continue;
                int index = (int) (board[j][i] - '1');
                if (freq[index])
                    return false;
                freq[index] = true;
            }
        }
        // check subsquares for duplicates.
        for (int i = 0; i < board.length; i += 3)
            for (int j = 0; j < board.length; j += 3)
                if (!checkSquare(board, i, j))
                    return false;

        return true;
    }

    private boolean checkSquare(char[][] board, int y, int x) {
        // Same principle of a frequency array used here.
        boolean[] freq = new boolean[10];
        for (int i = y; i < y + 3; i++)
            for (int j = x; j < x + 3; j++) {
                if (board[j][i] == '.')
                    continue;
                int index = (int) (board[j][i] - '1');
                if (freq[index])
                    return false;
                freq[index] = true;
            }
        return true;
    }
}