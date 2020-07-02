import java.util.HashSet;
//Path Crossing
/**
 * P1496
 */
public class P1496 {

    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        for (int i = 0; i < path.length(); i++) {
            char d = path.charAt(i);
            if (d == 'N')
                y += 1;
            if (d == 'E')
                x += 1;
            if (d == 'W')
                x -= 1;
            if (d == 'S')
                y -= 1;
            if (visited.contains(x + y * (path.length() + 1)))
                return true;
            visited.add(x + y * (path.length() + 1));

        }
        return false;
    }
}
