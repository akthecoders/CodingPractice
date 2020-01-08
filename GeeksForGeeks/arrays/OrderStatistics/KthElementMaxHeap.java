package OrderStatistics;

/**
 * KthElementMaxHeap
 */
public class KthElementMaxHeap {

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(getKthElement(arr, k));
    }

    public static Integer getKthElement(int arr[] , int k) {
        MaxPriorityQueue maxQueue = new MaxPriorityQueue();
        for (int i : arr) {
            maxQueue.insertElement(i);
        }
        for(int i = 0; i < arr.length - k; i++) {
            maxQueue.removeElement();
        }
        return maxQueue.getMax();
    }
}