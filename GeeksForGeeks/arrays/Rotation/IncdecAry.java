package Rotation;
// Given an array arr[] of N distinct elements, the task is to check if it is possible to make the array increasing or decreasing by rotating the array in any direction.

import java.util.Scanner;

/**
 * IncdecAry
 */
public class IncdecAry {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int noOfElements = scan.nextInt();
        int[] intAry = new int[noOfElements];
        for(int i = 0; i < noOfElements; i++) {
            intAry[i] = scan.nextInt();
        }
        if(noOfElements == 1) {
            System.out.println("Yes");
        }
        else if(isIncreasing(intAry, noOfElements, 1)) {
            System.out.println("Yes");
        }
        else if(isDecreasing(intAry, noOfElements, 1)) {
            System.out.println("Yes");
        }
        else if(canBeMadeInc(intAry, noOfElements)) {
            System.out.println("Yes");
        }
        else if(canBeMadeDec(intAry, noOfElements)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        scan.close();
    }

    private static boolean isIncreasing(int[] intAry, int noOfElements, int index) {
        if(noOfElements == 1) {
            return true;
        }
        if(index >= noOfElements) {
            return true;
        }

        if(intAry[index - 1] < intAry[index]) {
            return isIncreasing(intAry, noOfElements, index + 1);
        }
        else {
            return false;
        }
    }

    private static boolean isDecreasing(int[] intAry, int noOfElements, int index) {
        if(noOfElements == 1) {
            return true;
        }
        if(index >= noOfElements) {
            return true;
        }

        if(intAry[index - 1] > intAry[index]) {
            return isDecreasing(intAry, noOfElements, index + 1);
        }
        else {
            return false;
        }
    }

    private static boolean canBeMadeInc(int[] intAry, int noOfElements) {
        if(noOfElements == 1) {
            return true;
        }
        int incUptoElementNo = 1; 
        for(int i = 1; i < noOfElements; i++) {
            if(intAry[i - 1] < intAry[i]) {
                incUptoElementNo++;
            }
            else {
                break;
            }
        } 
        return isDecreasing(intAry, noOfElements, incUptoElementNo + 1);
    }

    private static boolean canBeMadeDec(int[] intAry, int noOfElements) {
        if(noOfElements == 1) {
            return true;
        }
        int decUptoElementNo = 1; 
        for(int i = 1; i < noOfElements; i++) {
            if(intAry[i - 1] > intAry[i]) {
                decUptoElementNo++;
            }
            else {
                break;
            }
        }
        return isIncreasing(intAry, noOfElements, decUptoElementNo + 1);
    }
} 