import java.util.Scanner;

/**
 * PlayWithArray
 */
public class PlayWithArray {

  public static void main(String [] args) {
    Scanner scan = new Scanner(System.in);
    int noOfElements = scan.nextInt();
    int[] intAry = new int[noOfElements];
    for(int j = 0; j < noOfElements; j++) {
        intAry[j] = scan.nextInt();
    }
    scan.close();
    formatArray(intAry, noOfElements);
    printArray(intAry, noOfElements);
  }

  public static void formatArray(int[] ary, int noOfElements) {
    sortArray(ary);
    for(int i = 0; i < noOfElements; i = i + 2) {
      if(i + 1 < noOfElements) { 
        swap(ary, i, i + 1);
      }
    } 
  }

  public static void swap(int[] ary, int fElement, int sElement) {
    ary[fElement] = ary[fElement] + ary[sElement];
    ary[sElement] = ary[fElement] - ary[sElement];
    ary[fElement] = ary[fElement] - ary[sElement];
  }

  public static void sortArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length-1-i; j++) { 
        if(arr[j]<arr[j+1])
        {
          int temp=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=temp;
        }
      }
    }
  }

  public static void printArray(int[] ary, int noOfElements) {
    for(int i = 0; i < noOfElements; i++) {
      System.out.print(ary[i] + " ");
    }
    System.out.println();
  }
}