package Rearrangement;

/**
 * ArrangeInZigZag
 */
public class ArrangeInZigZag {

    public static void main(String[] args) {
        int arr[] = new int[] { 4, 3, 7, 8, 6, 2, 1 };
        zigZag(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void zigZag(int[] arr) {
        int n = arr.length;
        boolean flag = true;
        int temp = 0;
        for (int i = 0; i < n - 2; i++) {
            if (flag) // expecting <
            {
                if(arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            else {
                if(arr[i] < arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            flag = !flag;
        }
    }
}