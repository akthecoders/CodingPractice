import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Powerful Integers
public class P970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> p = new HashSet<Integer>();
        for (int i = 1; i < bound; i *= x > 1 ? x : bound)
            for (int j = 1; i + j <= bound; j *= y > 1 ? y : bound)
                p.add(i + j);
        return new ArrayList<Integer>(p);
    }
}