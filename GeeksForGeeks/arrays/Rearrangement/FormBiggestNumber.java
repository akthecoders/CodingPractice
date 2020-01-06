package Rearrangement;

/**
 * FormBiggestNumber
 */
public class FormBiggestNumber {

    public static void main(String[] args) {
        int[] arr =  {54, 546, 548, 60};
        int n = 4;
        System.out.println(biggestNumber(arr, n)); 
    }

    private static double biggestNumber(int[] arr, int n) {
        if(arr.length == 1) {
            return (double)arr[0];
        }
        int tAry[] = new int[n - 1];
        for(int i = 1; i < n; i++) {
            tAry[i - 1] = arr[i];
        }
        int myNum = arr[0];
        double recursiveNum = biggestNumber(tAry, n - 1);
        double order = getMultiplyWith(recursiveNum);
        double order2 = getMultiplyWith(myNum);
        
        System.out.println(myNum + "-" + recursiveNum + "-" + order + "-" + order2);

        double num1 = myNum * order + recursiveNum;
        double num2 = myNum + recursiveNum * order2;
        if( num1 > num2) {
            return num2;
        }
        else {
            return num2;
        }
    }

    private static double getMultiplyWith(double n){
        int count = 1;
        while(n > 0) {
            count = count * 10;
            n = (int)n / 10;
        }
        return count;
    }
}