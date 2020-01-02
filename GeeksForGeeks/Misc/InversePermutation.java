import java.util.Scanner;

/**
 * InversePermutation
 */
public class InversePermutation {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int noOfElements = scan.nextInt();
        int[] intAry = new int[noOfElements];
        for(int j = 0; j < noOfElements; j++) {
            int temp = scan.nextInt();
            intAry[temp - 1] = j + 1;
        }
        scan.close();
        for(int j = 0; j < noOfElements; j++) {
            System.out.print(intAry[j] + " ");
        }
    }
}