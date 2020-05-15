//Find Winner on a Tic Tac Toe Game
public class P1275 {
    public boolean rowcol(char ab, char[][] a) {
        if (a[0][0] == a[0][1] && a[0][1] == a[0][2] && a[0][0] == ab)
            return true;
        if (a[1][0] == a[1][1] && a[1][1] == a[1][2] && a[1][0] == ab)
            return true;
        if (a[2][0] == a[2][1] && a[2][1] == a[2][2] && a[2][0] == ab)
            return true;
        if (a[0][0] == a[1][0] && a[1][0] == a[2][0] && a[0][0] == ab)
            return true;
        if (a[0][1] == a[1][1] && a[1][1] == a[2][1] && a[0][1] == ab)
            return true;
        if (a[0][2] == a[1][2] && a[1][2] == a[2][2] && a[0][2] == ab)
            return true;
        else
            return false;
    }

    public boolean diag(char ab, char[][] a) {
        if (a[0][0] == a[1][1] && a[1][1] == a[2][2] && a[0][0] == ab)
            return true;
        if (a[0][2] == a[1][1] && a[1][1] == a[2][0] && a[0][2] == ab)
            return true;
        return false;
    }

    public String tictactoe(int[][] moves) {
        char c[][] = new char[3][3];
        int count = 0;
        for (int ch[] : moves) {
            int a = ch[0];
            int b = ch[1];
            count++;
            if (count % 2 == 1)
                c[a][b] = 'X';
            else
                c[a][b] = 'O';
        }
        if (rowcol('X', c) == true || diag('X', c) == true)
            return "A";
        else if (rowcol('O', c) == true || diag('O', c) == true)
            return "B";
        else if (count != 9)
            return "Pending";
        else
            return "Draw";
    }
}