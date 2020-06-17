import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//Largest Values From Labels
public class P1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        List<Item> list = new ArrayList<>();
        for(int i = 0; i < labels.length;i++) {
            list.add(new Item(labels[i], values[i]));
        }
        PriorityQueue<Item> pQ = new PriorityQueue<>((Item a, Item b) -> b.value - a.value);
        pQ.addAll(list);
        
        Map<Integer, Integer> map = new HashMap<>();
        int value = 0;
        while(!pQ.isEmpty() && num_wanted > 0) {
            Item curr = pQ.poll();
            map.put(curr.label, map.getOrDefault(curr.label, 0) + 1);
            if(map.get(curr.label) <= use_limit) {
                value += curr.value;
                num_wanted--;
            }
        }
        return value;
    }

    class Item {
        int label;
        int value;

        public Item(int l, int v) {
            this.label = l;
            this.value = v;
        }
    }
}