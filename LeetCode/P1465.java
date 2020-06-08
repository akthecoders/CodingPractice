import java.util.Arrays;

//Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
public class P1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final int MOD = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int prev = 0, hor = 0, ver = 0;
        for (int i : horizontalCuts) {
            hor = Math.max(hor, i - prev);
            prev = i;
        }
        hor = Math.max(hor, h - prev);
        prev = 0;
        for (int i : verticalCuts) {
            ver = Math.max(ver, i - prev);
            prev = i;
        }
        ver = Math.max(ver, w - prev);
        long ans = hor % MOD;
        ans = ans * (long) (ver % MOD);
        ans = ans % MOD;
        return (int) ans;
    }
}