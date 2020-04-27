// Valid Tic-Tac-Toe State

public class P794 {
    int win[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
            { 2, 4, 6 } };

    boolean isCWin(char[] board, char c) {
        for (int i = 0; i < 8; i++) {
            if (board[win[i][0]] == c && board[win[i][1]] == c && board[win[i][2]] == c) {
                return true;
            }
        }
        return false;
    }

    public boolean validTicTacToe(String[] board) {
        char[] tic = new char[9];
        int index = 0;
        for (String s : board) {
            tic[index++] = s.charAt(0);
            tic[index++] = s.charAt(1);
            tic[index++] = s.charAt(2);
        }

        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 9; i++) {
            if (tic[i] == 'O') {
                oCount++;
            } else if (tic[i] == 'X') {
                xCount++;
            }
        }

        if (xCount == oCount || xCount == oCount + 1) {
            if (isCWin(tic, 'O')) {
                if (isCWin(tic, 'X')) {
                    return false;
                }

                return (xCount == oCount);
            }

            if (isCWin(tic, 'X') && xCount != oCount + 1) {
                return false;
            }

            return true;
        }

        return false;
    }
}