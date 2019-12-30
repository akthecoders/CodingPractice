package Rotation;

/**
 * MaxContigous1Binary
 */
public class MaxContigous1Binary {

  public static void main(String args[]) {
    String binaryString = "001100111000110011100";
    int rotation = 2;
    int[] numArray = new int[binaryString.length()];

    int counter = 0;
    for(int i = 0; i < binaryString.length(); i++) {
      int count = 0;
      if(binaryString.charAt(i) == '1') {
        int j = i;
        while(j < binaryString.length() && binaryString.charAt(j) == '1') {
          count++;
          j++;
        }
        numArray[counter++] = count;
        i = j-1;
      }
    }

    while(rotation > 0 ) {
      TopTwo top = getTwoMaxNumbers(numArray);
      if(top.maxOne == 0 && top.maxTwo == 0) {
        break;
      }
      int sum = top.maxOne + top.maxTwo;
      numArray[counter++] = sum;
      rotation--;
    }

    TopTwo top = getTwoMaxNumbers(numArray);
    System.out.println(top.maxOne);
  }

  public static TopTwo getTwoMaxNumbers(int[] nums){
    int maxOne = 0;
    int iMax = 0;
    int maxTwo = 0;
    int iTwo = 0;
    int index = 0;
		for(int n:nums){
			if(maxOne < n){
        maxTwo = maxOne;
        iTwo = iMax;
        maxOne = n;
        iMax = index;
			} else if(maxTwo < n){
        maxTwo = n;
        iTwo = index;
      }
      index++;
    }
    nums[iMax] = 0;
    nums[iTwo] = 0;
    TopTwo top = new TopTwo();
    top.maxOne = maxOne;
    top.maxTwo = maxTwo;
    return top;
  }
  
}

class TopTwo {
  int maxOne;
  int maxTwo;
  public TopTwo() {
    this.maxOne = 0;
    this.maxTwo = 0;
  }
}