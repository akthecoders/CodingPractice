package OrderStatistics;

/**
 * IncreaseingSubSequenceOfLengthThree
 */
public class IncreaseingSubSequenceOfLengthThree {

  public static void main(String[] args) {
    int arr[] = {6, 7, 8, 1, 2, 3, 9, 10};
    subSequenceOfThree(arr);
  }

  public static void subSequenceOfThree(int[] arr) {
    int n = arr.length;
    int LSL[] = new int[n];
    int LGR[] = new int[n];
    LSL[0] = -1;
    for(int i = 1; i < n; i++) {
      int ls = -1;
      for(int j = 0; j < i; j++) {
        if(ls < arr[j] && arr[j] < arr[i]) {
          ls = arr[j];
        }
      }
      LSL[i] = ls;
    }
    LGR[n-1] = -1; 
    for(int i = n - 2; i >= 0; i--) {
      int lg = -1;
      for(int j = i + 1; j < n; j++) {
        if(lg < arr[j] && arr[j] > arr[i]) {
          lg = arr[j];
        }
      }
      LGR[i] = lg;
    }
    int maxProduct = 1;
    int index = 0;
    int tProduct = 1;
    for(int i = 1; i < n - 1; i++) {
        tProduct = LSL[i] * arr[i] * LGR[i];
        if(tProduct > maxProduct) {
          maxProduct = tProduct;
          index = i;
        }
    }
    System.out.println(LSL[index] + " " + arr[index] + " " + LGR[index]);
  }
}