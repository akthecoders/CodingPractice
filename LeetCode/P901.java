// Online Stock Spanner
import java.util.*;
public class P901 {
    Stack<Pair> s;

    public P901() {
        this.s = new Stack<>();
    }

    public int next(int price) {
        int count = 1;

        while (!this.s.isEmpty() && this.s.peek().val <= price) {
            count += this.s.pop().count;
        }
        s.push(new Pair(price, count));
        return count;
    }

    class Pair {
        int val;
        int count;

        Pair(int v, int c) {
            this.val = v;
            this.count = c;
        }
    }
}