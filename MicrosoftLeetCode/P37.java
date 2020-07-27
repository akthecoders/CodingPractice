//Sudoku Solver
public class P37 {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    public boolean backtrack(char[][] board, int row, int col) {
        if (col == board[row].length) {
            col = 0;
            row++;

            if (row == board.length) {
                return true;
            }
        }

        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }

        for (int i = 1; i <= board.length; i++) {
            if (canSetValue(board, row, col, (char) (i + '0'))) {
                board[row][col] = (char) (i + '0');
                if (backtrack(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;

    }

    public boolean canSetValue(char[][] board, int row, int col, char value) {
        for (int i = 0; i < board[row].length; i++) {
            if (value == board[row][i]) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (value == board[i][col]) {
                return false;
            }
        }

        int squareSize = (int) Math.floor((int) Math.sqrt(board.length));
        int squareRow = (int) Math.floor(row / squareSize);
        int squareCol = (int) Math.floor(col / squareSize);

        int topLeftRow = squareSize * squareRow;
        int topLeftCol = squareSize * squareCol;

        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                if (board[topLeftRow + i][topLeftCol + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}