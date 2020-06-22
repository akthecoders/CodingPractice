//The k-th Lexicographical String of All Happy Strings of Length n
public class P1415 {
    int k;

    public String getHappyString(int n, int k) {
        this.k = k;
        return dfs(n, 0, "");
    }

    public String dfs(int n, int i, String s) {
        if (i == n)
            return (--k == 0) ? s : "";
        for (char c = 'a'; c <= 'c'; c++) {
            if (!s.isEmpty() && s.charAt(s.length() - 1) == c)
                continue;
            String res = dfs(n, i + 1, s + c);
            if (!res.isEmpty())
                return res;
        }
        return "";
    }
}