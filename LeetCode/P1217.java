//Play with Chips
public class P1217 {
    public int minCostToMoveChips(int[] chips) {
        int[] c = new int[2];
        for (int x : chips) {
            if (x % 2 == 0)
                c[0]++;
            else
                c[1]++;
        }
        return Math.min(c[0], c[1]);
    }
}