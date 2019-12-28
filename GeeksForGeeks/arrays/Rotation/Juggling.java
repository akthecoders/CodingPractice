package Rotation;

import java.util.Scanner;

/**
 * Juggling
 */
public class Juggling {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int noOfElements = scan.nextInt();
        int rotate = scan.nextInt();
        int[] intAry = new int[noOfElements];
        for(int i = 0; i < noOfElements; i++) {
            intAry[i] = scan.nextInt();
        }
        juggle(intAry, rotate, noOfElements);
        printArray(intAry, noOfElements);
        scan.close();
    }

    private static void juggle(int[] intAry, int rotate, int noOfElements) {
        int gcd = getGCD(rotate , noOfElements);
        int temp, k, j;
        for(int i =0; i < gcd; i++) {
            temp = intAry[i];
            j = i;
            while(true) {
                k = j + rotate;
                if(k >= noOfElements) {
                    k = k - noOfElements;
                }
                if(k == i) {
                    break;
                }
                intAry[j] = intAry[k];
                j = k;
            }
            intAry[j] = temp;
        }
    }

    private static int getGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    private static void printArray(int[] intAry, int noOfElements) {
        for(int i = 0; i < noOfElements; i++) {
            System.out.print(intAry[i] + " ");
        }
        System.out.println();
    }

}