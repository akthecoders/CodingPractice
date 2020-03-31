import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LargestTriplet
 */
public class LargestTriplet {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 }; 
        int n = arr.length; 
        LargestTripletMultiplication(arr, n);
    }

    public static void LargestTripletMultiplication(int[] arr, int n) {

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            q.add(i);
        }
        
        System.out.println("Trplet sum : " +  (q.poll() * q.poll() * q.poll()));
    }
}