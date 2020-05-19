import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Reveal Cards In Increasing Order
public class P950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < deck.length; ++i)
            q.offer(i);
        for (int i = 0; i < deck.length; ++i) {
            res[q.poll()] = deck[i];
            q.offer(q.poll());
        }
        return res;
    }
}