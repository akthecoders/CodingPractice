//Regular Expression Matching
public class P10 {
    public boolean isMatch(String s, String p) {
        boolean T[][] = new boolean[s.length() + 1][p.length() + 1];
        T[0][0] = true;

        for (int i = 1; i < T[0].length; i++) {
            if (p.charAt(i - 1) == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (sc == pc || pc == '.') {
                    T[i][j] = T[i - 1][j - 1];
                } else if (pc == '*') {
                    T[i][j] = T[i][j - 2];
                    char pm2 = p.charAt(j - 2);
                    char tm1 = s.charAt(i - 1);

                    if (pm2 == '.' || pm2 == tm1) {
                        T[i][j] = T[i][j] || T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }

        return T[s.length()][p.length()];
    }
}

//Revision