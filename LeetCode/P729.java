import java.util.TreeMap;

//My Calendar I
public class P729 {
    TreeMap<Integer, Integer> calendar;
    public P729() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
       Integer prev = calendar.floorKey(start), next = calendar.ceilingKey(start);
        if((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}