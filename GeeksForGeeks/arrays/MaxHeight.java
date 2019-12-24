import java.util.ArrayList;
import java.util.Scanner;

/**
 * MaxHeight
 */
public class MaxHeight {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int noOfTestCases = scan.nextInt();
    for(int i = 0; i < noOfTestCases; i++) {
      int noOfHeights = scan.nextInt();
      ArrayList<Height> heights = inputHeights(noOfHeights, scan);
      System.out.println("Max Height : " + getMaxHeightOfAll(heights, noOfHeights));
    }
    scan.close();
  }

  private static ArrayList<Height> inputHeights(int noOfHeights, Scanner scan) {
    ArrayList<Height> heights = new ArrayList<>();
    for(int i = 0; i < noOfHeights; i++) {
      heights.add(new Height(scan.nextInt(), scan.nextInt()));
    }
    return heights;
  }

  private static int getMaxHeightOfAll(ArrayList<Height> heights, int noOfHeights) {
    int maxHeight = 0;
    for(int i = 0; i < noOfHeights; i++) {
      Height height = heights.get(i);
      int tHeight = height.feet * 12 + height.inches;
      if(tHeight > maxHeight) {
        maxHeight = tHeight;
      }
    }
    return maxHeight;
  }



}

class Height {
	int feet;
	int inches;
	public Height(int ft, int inc)
	{
	    feet = ft;
	    inches = inc;
	}
}