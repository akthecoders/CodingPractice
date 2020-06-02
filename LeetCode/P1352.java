import java.util.ArrayList;

public class P1352 {
    ArrayList<Integer> list;
    public P1352() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        if(num == 0) {
            list = new ArrayList<>();
            list.add(1);
        }
        else {
            list.add(list.get(list.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int n = list.size();
        return (k<n) ? list.get(n-1)/list.get(n-k-1): 0;
    }
}