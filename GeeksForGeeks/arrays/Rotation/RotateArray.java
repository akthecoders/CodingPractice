package Rotation;

import java.util.*;
class RotateArray
 {
	public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    int noOfTestCases = scan.nextInt();
    for(int i = 0; i < noOfTestCases; i++) {
      takeInput(scan);
    }
    scan.close();
  }

  public static void takeInput(Scanner scan) {
    int noOfElements = scan.nextInt();
    int rotateTimes = scan.nextInt();
    int[] intAry = new int[noOfElements];
    for(int j = 0; j < noOfElements; j++) {
        intAry[j] = scan.nextInt();
    }
    // rotateArray(intAry, rotateTimes, noOfElements);
    printWithReverse(intAry, rotateTimes, noOfElements);
 
  }

  public static void rotateArray(int[] intAry, int rotateTimes, int noOfElements) {
    int k = rotateTimes %  noOfElements;
    reverse(intAry, 0, noOfElements - 1);
    reverse(intAry, 0, (noOfElements - k) - 1);
    reverse(intAry, (noOfElements - k), noOfElements - 1);
 
    for(int j = 0; j < noOfElements; j++) {
      System.out.print( intAry[j] + " ");
    }
    System.out.println();
  }

  public static void reverse(int[] ary, int start, int end) {
    while(start < end) {
      int temp = ary[start];
      ary[start] = ary[end];
      ary[end] = temp;
      start++;
      end--;
    }
  }

  public static void printWithReverse(int[] ary, int rotateTime, int sizeOfAry) {
    int mod = rotateTime % sizeOfAry;
    for(int i = 0; i < sizeOfAry; i++) {
      System.out.print(ary[(i + mod) % sizeOfAry] + " ");
    }
    System.out.println();
  }
}