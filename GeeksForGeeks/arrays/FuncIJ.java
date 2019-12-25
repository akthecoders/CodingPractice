import java.util.Scanner;

/**
 * FuncIJ
 */
public class FuncIJ {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int noOfElements = scan.nextInt();
        int[] intAry = new int[noOfElements];
        for(int j = 0; j < noOfElements; j++) {
            intAry[j] = scan.nextInt();
        }
        System.out.println(sumFunction(intAry, noOfElements));
        scan.close();
    }

    public static int sumFunction(int[] ary, int noOfElements) {
        int result = 0;
        for(int i = 0; i < noOfElements; i = i++) {
            for(int j = i + 1; j < noOfElements; j++) {
                result += ary[j] - ary[i];
            }
        }
        return result;
    }
}