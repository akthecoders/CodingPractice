public class TowerOfHanoi {
    public static void main(String args[]) {
        solve(3, 1, 2, 3);
    }

    public static void solve(int n, int s, int d, int h) {
        if(n == 1) {
            System.out.println("Move plate " + n + " from " + s + " to " + d);
            return;
        }
        solve(n - 1, s, h, d);
        System.out.println("Move plate " + n + " from " + s + " to " + d);
        solve(n - 1, h, d, s);
    }
}