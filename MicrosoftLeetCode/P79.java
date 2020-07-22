//Word Search
public class P79 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 && board[0].length == 0)
            return false;
        if (word.length() == 0)
            return true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '*' && board[i][j] == word.charAt(0)) {
                    if (solver(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean solver(char[][] board, String word, int pos, int row, int col) {
        if (pos >= word.length())
            return true;

        char c = word.charAt(pos);
        if (board[row][col] != c) {
            return false;
        }

        if ((pos + 1) == word.length())
            return true;

        board[row][col] = '*';
        int dirs[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        char nCh = word.charAt(pos + 1);

        for (int[] dir : dirs) {
            int nR = row + dir[0];
            int nC = col + dir[1];
            if (nR >= 0 && nR < board.length && nC >= 0 && nC < board[0].length && board[nR][nC] != '*'
                    && board[nR][nC] == nCh) {
                if (solver(board, word, pos + 1, nR, nC)) {
                    return true;
                }
            }
        }

        board[row][col] = c;
        return false;
    }
}