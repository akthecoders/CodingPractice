class SubSetArray {
  public static void main(String args[]) {
    int[] input = new int[3];
    input[0] = 15;
    input[1] = 20;
    input[2] = 12;

    int[][] result = findSubsets(input, 0, input.length);
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }

  }

  public static int[][] findSubsets(int[] input, int start, int end) {
    if (end - start == 1) {
      int smallAns[][] = new int[1][1];
      smallAns[0][0] = input[start];
      return smallAns;
    }

    else {
      int[][] smallInput = findSubsets(input, start + 1, end);
      int result[][] = new int[(2 * smallInput.length) + 1][];

      int rows = smallInput.length;
      int ary[] = new int[1];
      ary[0] = input[start];
      result[0] = ary;
      int count = 1;
      for (int i = 0; i < rows; i++) {
        result[count++] = smallInput[i];
      }

      int numToAdd = input[start];
      for (int i = 0; i < rows; i++) {
        int colSize = smallInput[i].length;
        int[] newArray = new int[colSize + 1];
        newArray[0] = numToAdd;
        for (int j = 0; j < colSize; j++) {
          newArray[j + 1] = smallInput[i][j];
        }
        result[count++] = newArray;
      }
      return result;
    }
  }
}