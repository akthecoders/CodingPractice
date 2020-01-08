package OrderStatistics;

/**
 * KthElementMinHeap
 */
public class KthElementMinHeap {

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(getKthSmallestElement(arr, k));
    }

    public static Integer getKthSmallestElement(int[] arr, int k) {
        Integer result = 0;
        MinPriorityQueue minQueue = new MinPriorityQueue();
        for (int i : arr) {
            minQueue.insertData(Integer.valueOf(i));   
        }
        for(int i = 0; i < k - 1; i++) {
            minQueue.removeElement();
        }
        return minQueue.getMin();
    }
}