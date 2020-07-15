//Design Tic-Tac-Toe
public class P348 {
    int r[];
    int c[];
    int diagLeft;
    int diagRight;
    int n;

    /** Initialize your data structure here. */
    public P348(int n) {
        this.r = new int[n];
        this.c = new int[n];
        this.diagLeft = 0;
        this.diagRight = 0;
        this.n = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     * 
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either: 0: No one wins. 1:
     *         Player 1 wins. 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int move = player == 1 ? 1 : -1;

        r[row] += move;
        c[col] += move;
        if (row == col)
            diagLeft += move;
        if (row == n - col - 1)
            diagRight += move;

        if (r[row] == n || c[col] == n || diagLeft == n || diagRight == n) {
            return 1;
        } else if (r[row] == -n || c[col] == -n || diagLeft == -n || diagRight == -n) {
            return 2;
        }
        return 0;
    }
}