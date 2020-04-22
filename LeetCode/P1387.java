import java.util.HashMap;
import java.util.PriorityQueue;

public class P1387 {
    public static void main(String[] args) {
        int lo = 1;
        int hi = 1000;
        int k = 777;

        P1387 sol = new P1387();
        System.out.println(sol.getKth(lo, hi, k));
    }

    public class Entry implements Comparable<Entry>{
        private int key;
        public int value;
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
        
        public int getKey(){return this.key;}
        public int getvalue(){return this.value;}
        
        @Override
        public int compareTo(Entry other) {
            if(this.getKey()<other.getKey())
                return -1;
            else if(this.getKey() == other.getKey())
                return this.getvalue() < other.getvalue() ? -1:1;
            else
                return 1;
        }
    }
    
    HashMap<Integer, Integer> hm;
    public int getKth(int lo, int hi, int k) {
        hm = new HashMap<Integer,Integer>();
        PriorityQueue<Entry> q = new PriorityQueue<>();
        for(int i =lo; i <= hi; i++){
            q.add(new Entry(getPower(i), i));
        }
        Entry ans = q.peek();
        for(int j = 0; j < k; j++){
            ans = q.poll();
        }        
        return ans.getvalue();
    }

    private int getPower(int num){
        if(num == 1)
            return 0;
        
        if(hm.containsKey(num))
            return hm.get(num);
        
        int tmp = 0;
        if(num%2 == 0){
            tmp = getPower(num/2)+1;
        }
        else
            tmp = getPower(num*3+1)+1;
        
        hm.put(num, tmp);
        return tmp;
    }
}