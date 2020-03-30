/**
 * CheckIfGivenArrayRepresentHeap
 */
public class CheckIfGivenArrayRepresentHeap {

    public static void main(String[] args) {
        int arr[] = {90, 15, 10, 7, 12, 2, 7, 3}; 
        int n = arr.length-1; 
        if (isHeap(arr, 0, n)) { 
            System.out.println("Yes"); 
        } else { 
            System.out.println("No"); 
        } 
    }

    public static boolean isHeap(int[] arr, int start, int end) {
        if(start > (((end - 2))/2)) {
            return true;
        }

        if(arr[start] > arr[(2*start + 1)] && arr[start] > arr[(2*start + 2)] && isHeap(arr, 2*start + 1, end) && isHeap(arr, 2*start + 2, end)) {
            return true;
        }

        return false;
    }
}