package Rearrangement;

/**
 * ReplaceEveryElementOnRightByLarge
 */
public class ReplaceEveryElementOnRightByLarge {

    public static void main(String[] args) {
        int arr[] = { 16, 17, 4, 3, 5, 2 };
        nextGreatest(arr);
        System.out.println("The modified array:");
        printArray(arr);
    }

    public static void nextGreatest(int[] arr) {
        int n = arr.length;
        int maxFromRight = arr[n-1];
        arr[n-1] = -1;
        for(int i = n - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = maxFromRight;
            if(temp > maxFromRight) {
                maxFromRight = temp;
            }
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

}