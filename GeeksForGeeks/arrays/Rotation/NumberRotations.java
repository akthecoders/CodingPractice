package Rotation;

import java.util.Scanner;

/**
 * NumberRotations
 * NumberRotationsGiven an integer n, the task is to generate all the left shift numbers possible. 
 * A left shift number is a number that is generated when all the digits of the number are shifted one position to the left 
 * and the digit at the first position is shifted to the last.
 */

public class NumberRotations {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        printAllRotations(number);
        scan.close();
    }

    private static void printAllRotations(int number) {
        int digits = numberOfDigits(number);
        int pow = (int) Math.pow(10, digits - 1);
        for(int i = 0; i < digits - 1; i++ ) {
            int firstDigit = number / pow;
            int left = (number * 10) + firstDigit - (firstDigit * pow * 10);
            System.out.println( left + " ");
            number = left;
        }
    }

    private static int numberOfDigits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n /= 10;
        }
        return cnt;
    } 
}