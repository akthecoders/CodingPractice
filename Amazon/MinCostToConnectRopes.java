import java.util.PriorityQueue;

public class MinCostToConnectRopes {
    public static void main(String[] args) {
        int[] input = {8, 4, 6, 12};
        System.out.println("Cost : " + getCost(input));
    }

    public static int getCost(int[] input) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i: input) {
            pQ.add(i);
        }
        int total = 0;
        while(pQ.size() > 1) {
            int sum = pQ.poll() + pQ.poll();
            pQ.add(sum);
            total += sum;
        }
        return total;
    }
}
