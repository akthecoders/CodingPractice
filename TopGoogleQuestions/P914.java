import java.util.HashMap;
import java.util.Map;

//X of a Kind in a Deck of Cards
public class P914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 0)
            return false;
        if (deck.length == 1)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int freq = -1;
        for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
            int value = itr.getValue();

            if (freq == -1)
                freq = value;
            else
                freq = gcd(freq, value);
        }
        return freq >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
