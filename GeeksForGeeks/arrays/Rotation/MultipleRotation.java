package Rotation;

/**
 * MultipleRotation
 */
public class MultipleRotation {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 7, 9 };
        int n = arr.length;
        int rotates[] = {2,3,4};
        rotateAndPrint(arr, n, rotates);
    }

    private static void rotateAndPrint(int[] arr, int n, int[] rotates) {
        int[] tempAry = new int[n * 2];
        for(int i = 0; i < n; i++) {
            tempAry[i] = arr[i];
        }
        for(int i = 0; i < n; i++) {
            tempAry[i + n] = arr[i];
        }
        for(int i = 0; i < rotates.length; i++) {
            int rotate = rotates[i];
            for(int j = rotate; j < n + rotate; j++) {
                System.out.print(tempAry[j] + " ");
            }
            System.out.println();
        } 
    }
}