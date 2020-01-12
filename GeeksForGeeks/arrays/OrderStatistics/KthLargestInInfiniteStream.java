package OrderStatistics;

import java.util.Scanner;

/**
 * KthLargestInInfiniteStream
 */
public class KthLargestInInfiniteStream {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter value of k : ");
        int k = s.nextInt();
        System.out.println("Enter -1 to exit:");
        MaxPriorityQueue queue = new MaxPriorityQueue();
        while(true) {
            System.out.println("Enter new element : ");
            int data = s.nextInt();
            if(data != -1) {
                queue.insertElement(data);
            }
            else {
                break;
            }
        }
        for(int i = 0; i < k - 1 && i < queue.size; i++) {
            queue.removeElement();
        }
        System.out.println("Kth largest element is : " + queue.getMax());
    }
}