package OrderStatistics;

/**
 * FirstThreeLargest
 */
public class FirstThreeLargest {

  public static void main(String[] args) {
    int[] arr = {10, 4, 3, 50, 23, 90};
    printThreeLargest(arr);
  }

  public static void printThreeLargest(int[] arr) {
    int length = arr.length;
    int l = Integer.MIN_VALUE;
    int ll = Integer.MIN_VALUE;
    int lll = Integer.MIN_VALUE;

    for(int i = 0; i < length; i++) {
      if(l < arr[i]) {
        lll = ll;
        ll = l;
        l = arr[i]; 
      }
      else if(ll < arr[i]) {
        lll = ll;
        ll = arr[i];
      }
      else if(lll < arr[i]) {
        lll = arr[i];
      }
    }

    System.out.println("l, ll, lll => " + l + " " + ll + " " + lll);
  }
}