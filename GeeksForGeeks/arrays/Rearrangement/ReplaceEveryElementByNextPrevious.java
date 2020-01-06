package Rearrangement;

/**
 * ReplaceEveryElementByNextPrevious
 */
public class ReplaceEveryElementByNextPrevious {

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 6};
        int n = 5;

        for (int i : arr) {
            System.out.print(i + " ");
        }
        modify(arr, n);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void modify(int arr[], int n ) {
        if(n <= 1) {
            return;
        }   
        int prev = arr[0];
        arr[0] = arr[0] * arr[1];

        for(int i = 1; i < n - 1; i++) {
            int curr = arr[i];
            arr[i] = prev * arr[i+1];
            prev = curr;
        }
        arr[n-1] = prev * arr[n-1];
    }
}