import java.util.PriorityQueue;

//Kth Largest Element in a Stream
public class P703 {
    PriorityQueue<Integer> que;
    int size;
    public P703(int k, int[] nums) {
        size = k;
        que = new PriorityQueue<>((a,b) -> a - b);
        for(int num : nums){
            que.offer(num);
            if(que.size() > k){
                que.poll();
            }
        }
        
    }

    public int add(int val) {
        que.offer(val);
        if (que.size() > size) {
            que.poll();
        }
        return que.peek();
    }
}