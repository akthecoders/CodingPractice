//Available Captures for Rook
public class P999 {
    public int numRookCaptures(char[][] board) {
        int result = 0;
        int rX = 0;
        int rY = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'R') {
                    rX = i;
                    rY = j;
                }
            }
        }

        for (int i = rX; i >= 0; i--) {
            if (board[i][rY] == 'B') {
                break;
            }
            if (board[i][rY] == 'p') {
                result++;
                break;
            }
        }
        for (int i = rX; i < board.length; i++) {
            if (board[i][rY] == 'B') {
                break;
            }
            if (board[i][rY] == 'p') {
                result++;
                break;
            }
        }
        for (int i = rY; i < board.length; i++) {
            if (board[rX][i] == 'B') {
                break;
            }
            if (board[rX][i] == 'p') {
                result++;
                break;
            }
        }
        for (int i = rY; i >= 0; i--) {
            if (board[rX][i] == 'B') {
                break;
            }
            if (board[rX][i] == 'p') {
                result++;
                break;
            }
        }
        return result;
    }
}