package OrderStatistics;

/**
 * FindSmallestSecondSmallest
 */
public class FindSmallestSecondSmallest {

  public static void main(String[] args) {
    int arr[] = { 12, 13, 1, 10, 34, 1 };
    print2Smallest(arr);
  }

  public static void print2Smallest(int[] arr) {
    int s = Integer.MAX_VALUE;
    int ss = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i ++) 
        { 
            if (arr[i] < s) 
            { 
                ss = s; 
                s = arr[i]; 
            } 
            else if (arr[i] < ss && arr[i] != s) 
                ss = arr[i]; 
        } 
    if (ss == Integer.MAX_VALUE) 
            System.out.println("There is no second" + 
                               "smallest element"); 
        else
            System.out.println("The smallest element is " + 
                               s + " and second Smallest" + 
                               " element is " + ss); 
  }
}