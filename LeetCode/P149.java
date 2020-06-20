import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Max Points on a Line
public class P149 {
    public int maxPoints(int[][] points) {
        if (points.length < 3)
            return points.length;
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            Map<List<Integer>, Integer> map = new HashMap<>();
            int M1 = 1;
            int M2 = 1;
            int cnt = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                int x2 = points[j][0];
                int y2 = points[j][1];

                int diffx = (x2 - x1);
                int diffy = (y2 - y1);
                if (diffx == 0 && diffy == 0) {
                    cnt++;
                } else if (diffx == 0) {
                    M1++;
                } else if (diffy == 0) {
                    M2++;
                } else {
                    int g = (int) gcd(Math.abs(diffy), Math.abs(diffx));
                    diffx /= g;
                    diffy /= g;
                    List<Integer> list = new ArrayList<>();
                    list.add(diffy);
                    list.add(diffx);
                    if (!map.containsKey(list))
                        map.put(list, 1);
                    map.put(list, map.get(list) + 1);
                }
                for (List<Integer> key : map.keySet())
                    res = Math.max(res, cnt + map.get(key));
                res = Math.max(res, M1 + cnt);
                res = Math.max(res, M2 + cnt);
            }
        }

        return res;
    }

    public long gcd(long a, long b) {
        if (a < b)
            return gcd(b, a);
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}